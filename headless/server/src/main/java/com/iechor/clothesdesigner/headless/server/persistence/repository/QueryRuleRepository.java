package com.iechor.clothesdesigner.headless.server.persistence.repository;

import com.iechor.clothesdesigner.headless.api.pojo.request.QueryRuleFilter;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.QueryRuleDO;

import java.util.List;

public interface QueryRuleRepository {
    Integer create(QueryRuleDO queryRuleDO);

    Integer update(QueryRuleDO queryRuleDO);

    QueryRuleDO getQueryRuleById(Long id);

    List<QueryRuleDO> getQueryRules(QueryRuleFilter filter);
}
