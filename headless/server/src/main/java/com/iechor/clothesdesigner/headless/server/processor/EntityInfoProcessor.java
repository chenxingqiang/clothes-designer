package com.iechor.clothesdesigner.headless.server.processor;

import com.iechor.clothesdesigner.common.util.ContextUtils;
import com.iechor.clothesdesigner.headless.api.pojo.DataSetSchema;
import com.iechor.clothesdesigner.headless.api.pojo.EntityInfo;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;
import com.iechor.clothesdesigner.headless.chat.query.QueryManager;
import com.iechor.clothesdesigner.headless.server.facade.service.SemanticLayerService;

/**
 * EntityInfoProcessor fills core attributes of an entity so that users get to know which entity is
 * parsed out.
 */
public class EntityInfoProcessor implements ResultProcessor {

    @Override
    public void process(ParseResp parseResp, ChatQueryContext chatQueryContext) {
        parseResp
                .getSelectedParses()
                .forEach(
                        parseInfo -> {
                            String queryMode = parseInfo.getQueryMode();
                            if (!QueryManager.isDetailQuery(queryMode)
                                    && !QueryManager.isMetricQuery(queryMode)) {
                                return;
                            }

                            SemanticLayerService semanticService =
                                    ContextUtils.getBean(SemanticLayerService.class);
                            DataSetSchema dataSetSchema =
                                    semanticService.getDataSetSchema(parseInfo.getDataSetId());
                            EntityInfo entityInfo =
                                    semanticService.getEntityInfo(
                                            parseInfo, dataSetSchema, chatQueryContext.getUser());
                            parseInfo.setEntityInfo(entityInfo);
                        });
    }
}
