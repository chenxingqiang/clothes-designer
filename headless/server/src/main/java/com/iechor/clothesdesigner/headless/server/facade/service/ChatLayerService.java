package com.iechor.clothesdesigner.headless.server.facade.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.SqlEvaluation;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryMapReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryNLReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.QuerySqlReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.MapInfoResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.MapResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.SearchResult;

import java.util.List;

/** This interface adds natural language support to the semantic layer. */
public interface ChatLayerService {
    MapResp performMapping(QueryNLReq queryNLReq);

    ParseResp performParsing(QueryNLReq queryNLReq);

    MapInfoResp map(QueryMapReq queryMapReq);

    List<SearchResult> retrieve(QueryNLReq queryNLReq);

    void correct(QuerySqlReq querySqlReq, User user);

    SqlEvaluation validate(QuerySqlReq querySqlReq, User user);
}
