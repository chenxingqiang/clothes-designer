package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryRuleFilter;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryRuleReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.QueryRuleResp;

import java.util.List;

public interface QueryRuleService {
    QueryRuleResp addQueryRule(QueryRuleReq queryRuleReq, User user);

    QueryRuleResp updateQueryRule(QueryRuleReq queryRuleReq, User user);

    Boolean dropQueryRule(Long id, User user);

    QueryRuleResp getQueryRuleById(Long id, User user);

    List<QueryRuleResp> getQueryRuleList(QueryRuleFilter queryRuleFilter, User user);
}
