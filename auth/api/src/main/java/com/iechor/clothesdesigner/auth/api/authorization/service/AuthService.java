package com.iechor.clothesdesigner.auth.api.authorization.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.auth.api.authorization.pojo.AuthGroup;
import com.iechor.clothesdesigner.auth.api.authorization.request.QueryAuthResReq;
import com.iechor.clothesdesigner.auth.api.authorization.response.AuthorizedResourceResp;

import java.util.List;

public interface AuthService {
    List<AuthGroup> queryAuthGroups(String domainId, Integer groupId);

    void addOrUpdateAuthGroup(AuthGroup group);

    void removeAuthGroup(AuthGroup group);

    AuthorizedResourceResp queryAuthorizedResources(QueryAuthResReq req, User user);
}
