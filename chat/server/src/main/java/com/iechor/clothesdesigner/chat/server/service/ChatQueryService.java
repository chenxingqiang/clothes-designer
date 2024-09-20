package com.iechor.clothesdesigner.chat.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatExecuteReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatParseReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatQueryDataReq;
import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResult;
import com.iechor.clothesdesigner.headless.api.pojo.request.DimensionValueReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.SearchResult;

import java.util.List;

public interface ChatQueryService {
    List<SearchResult> search(ChatParseReq chatParseReq);

    ParseResp performParsing(ChatParseReq chatParseReq);

    QueryResult performExecution(ChatExecuteReq chatExecuteReq) throws Exception;

    QueryResult parseAndExecute(int chatId, int agentId, String queryText);

    Object queryData(ChatQueryDataReq chatQueryDataReq, User user) throws Exception;

    Object queryDimensionValue(DimensionValueReq dimensionValueReq, User user) throws Exception;
}
