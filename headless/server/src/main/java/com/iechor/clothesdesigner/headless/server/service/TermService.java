package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.TermReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.TermResp;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TermService {
    void saveOrUpdate(TermReq termSetReq, User user);

    void delete(Long id);

    List<TermResp> getTerms(Long domainId);

    Map<Long, List<TermResp>> getTermSets(Set<Long> domainIds);
}
