package com.iechor.clothesdesigner.headless.chat.parser.llm;

import com.iechor.clothesdesigner.common.util.ContextUtils;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;
import com.iechor.clothesdesigner.headless.chat.parser.SemanticParser;
import com.iechor.clothesdesigner.headless.chat.query.llm.s2sql.LLMReq;
import com.iechor.clothesdesigner.headless.chat.query.llm.s2sql.LLMResp;
import com.iechor.clothesdesigner.headless.chat.query.llm.s2sql.LLMSqlResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * LLMSqlParser uses large language model to understand query semantics and generate S2SQL
 * statements to be executed by the semantic query engine.
 */
@Slf4j
public class LLMSqlParser implements SemanticParser {

    @Override
    public void parse(ChatQueryContext queryCtx) {
        try {
            LLMRequestService requestService = ContextUtils.getBean(LLMRequestService.class);
            // 1.determine whether to skip this parser.
            if (requestService.isSkip(queryCtx)) {
                return;
            }
            // 2.get dataSetId from queryCtx and chatCtx.
            Long dataSetId = requestService.getDataSetId(queryCtx);
            if (dataSetId == null) {
                return;
            }
            log.info("try generating query statement for dataSetId:{}", dataSetId);

            // 3.invoke LLM service to do parsing.
            tryParse(queryCtx, dataSetId);
        } catch (Exception e) {
            log.error("failed to parse query:", e);
        }
    }

    private void tryParse(ChatQueryContext queryCtx, Long dataSetId) {
        LLMRequestService requestService = ContextUtils.getBean(LLMRequestService.class);
        LLMResponseService responseService = ContextUtils.getBean(LLMResponseService.class);
        int maxRetries = ContextUtils.getBean(LLMParserConfig.class).getRecallMaxRetries();

        LLMReq llmReq = requestService.getLlmReq(queryCtx, dataSetId);

        int currentRetry = 1;
        Map<String, LLMSqlResp> sqlRespMap = new HashMap<>();
        ParseResult parseResult = null;
        while (currentRetry <= maxRetries) {
            log.info("currentRetryRound:{}, start runText2SQL", currentRetry);
            try {
                LLMResp llmResp = requestService.runText2SQL(llmReq);
                if (Objects.nonNull(llmResp)) {
                    // deduplicate the S2SQL result list and build parserInfo
                    sqlRespMap = responseService.getDeduplicationSqlResp(currentRetry, llmResp);
                    if (MapUtils.isNotEmpty(sqlRespMap)) {
                        parseResult =
                                ParseResult.builder()
                                        .dataSetId(dataSetId)
                                        .llmReq(llmReq)
                                        .llmResp(llmResp)
                                        .build();
                        break;
                    }
                }
            } catch (Exception e) {
                log.error("currentRetryRound:{}, runText2SQL failed", currentRetry, e);
            }
            Double temperature = llmReq.getModelConfig().getTemperature();
            if (temperature == 0) {
                // 报错时增加随机性，减少无效重试
                llmReq.getModelConfig().setTemperature(0.5);
            }
            currentRetry++;
        }
        if (MapUtils.isEmpty(sqlRespMap)) {
            return;
        }
        for (Entry<String, LLMSqlResp> entry : sqlRespMap.entrySet()) {
            String sql = entry.getKey();
            double sqlWeight = entry.getValue().getSqlWeight();
            responseService.addParseInfo(queryCtx, parseResult, sql, sqlWeight);
        }
    }
}
