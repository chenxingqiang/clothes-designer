package com.iechor.clothesdesigner.chat.server.executor;

import com.iechor.clothesdesigner.chat.api.pojo.enums.MemoryStatus;
import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResult;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatMemoryDO;
import com.iechor.clothesdesigner.chat.server.pojo.ChatContext;
import com.iechor.clothesdesigner.chat.server.pojo.ExecuteContext;
import com.iechor.clothesdesigner.chat.server.service.ChatContextService;
import com.iechor.clothesdesigner.chat.server.service.MemoryService;
import com.iechor.clothesdesigner.chat.server.util.ResultFormatter;
import com.iechor.clothesdesigner.common.pojo.Text2SQLExemplar;
import com.iechor.clothesdesigner.common.util.ContextUtils;
import com.iechor.clothesdesigner.common.util.JsonUtil;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.request.QuerySqlReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.QueryState;
import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import com.iechor.clothesdesigner.headless.chat.query.llm.s2sql.LLMSqlQuery;
import com.iechor.clothesdesigner.headless.server.facade.service.SemanticLayerService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;

public class SqlExecutor implements ChatQueryExecutor {

    @SneakyThrows
    @Override
    public QueryResult execute(ExecuteContext executeContext) {
        QueryResult queryResult = doExecute(executeContext);

        if (queryResult != null) {
            String textResult =
                    ResultFormatter.transform2TextNew(
                            queryResult.getQueryColumns(), queryResult.getQueryResults());
            queryResult.setTextResult(textResult);

            if (queryResult.getQueryState().equals(QueryState.SUCCESS)
                    && queryResult.getQueryMode().equals(LLMSqlQuery.QUERY_MODE)) {
                Text2SQLExemplar exemplar =
                        JsonUtil.toObject(
                                JsonUtil.toString(
                                        executeContext
                                                .getParseInfo()
                                                .getProperties()
                                                .get(Text2SQLExemplar.PROPERTY_KEY)),
                                Text2SQLExemplar.class);

                MemoryService memoryService = ContextUtils.getBean(MemoryService.class);
                memoryService.createMemory(
                        ChatMemoryDO.builder()
                                .agentId(executeContext.getAgent().getId())
                                .status(MemoryStatus.PENDING)
                                .question(exemplar.getQuestion())
                                .sideInfo(exemplar.getSideInfo())
                                .dbSchema(exemplar.getDbSchema())
                                .s2sql(exemplar.getSql())
                                .createdBy(executeContext.getUser().getName())
                                .updatedBy(executeContext.getUser().getName())
                                .createdAt(new Date())
                                .build());
            }
        }

        return queryResult;
    }

    @SneakyThrows
    private QueryResult doExecute(ExecuteContext executeContext) {
        SemanticLayerService semanticLayer = ContextUtils.getBean(SemanticLayerService.class);
        ChatContextService chatContextService = ContextUtils.getBean(ChatContextService.class);

        ChatContext chatCtx = chatContextService.getOrCreateContext(executeContext.getChatId());
        SemanticParseInfo parseInfo = executeContext.getParseInfo();
        if (Objects.isNull(parseInfo.getSqlInfo())
                || StringUtils.isBlank(parseInfo.getSqlInfo().getCorrectedS2SQL())) {
            return null;
        }

        QuerySqlReq sqlReq =
                QuerySqlReq.builder().sql(parseInfo.getSqlInfo().getCorrectedS2SQL()).build();
        sqlReq.setSqlInfo(parseInfo.getSqlInfo());
        sqlReq.setDataSetId(parseInfo.getDataSetId());

        long startTime = System.currentTimeMillis();
        SemanticQueryResp queryResp = semanticLayer.queryByReq(sqlReq, executeContext.getUser());
        QueryResult queryResult = new QueryResult();
        queryResult.setChatContext(parseInfo);
        queryResult.setQueryMode(parseInfo.getQueryMode());
        queryResult.setQueryTimeCost(System.currentTimeMillis() - startTime);
        if (queryResp != null) {
            queryResult.setQueryAuthorization(queryResp.getQueryAuthorization());
            queryResult.setQuerySql(queryResp.getSql());
            queryResult.setQueryResults(queryResp.getResultList());
            queryResult.setQueryColumns(queryResp.getColumns());
            queryResult.setQueryState(QueryState.SUCCESS);

            chatCtx.setParseInfo(parseInfo);
            chatContextService.updateContext(chatCtx);
        } else {
            queryResult.setQueryState(QueryState.INVALID);
        }
        return queryResult;
    }
}
