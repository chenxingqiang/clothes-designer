package com.iechor.clothesdesigner.chat.server.executor;

import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResult;
import com.iechor.clothesdesigner.chat.server.plugin.PluginQueryManager;
import com.iechor.clothesdesigner.chat.server.plugin.build.PluginSemanticQuery;
import com.iechor.clothesdesigner.chat.server.pojo.ExecuteContext;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;

public class PluginExecutor implements ChatQueryExecutor {

    @Override
    public QueryResult execute(ExecuteContext executeContext) {
        SemanticParseInfo parseInfo = executeContext.getParseInfo();
        if (!PluginQueryManager.isPluginQuery(parseInfo.getQueryMode())) {
            return null;
        }
        PluginSemanticQuery query = PluginQueryManager.getPluginQuery(parseInfo.getQueryMode());
        query.setParseInfo(parseInfo);
        return query.build();
    }
}
