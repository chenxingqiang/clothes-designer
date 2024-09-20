package com.iechor.clothesdesigner.auth.api.authentication.adaptor;

import javax.servlet.http.HttpServletRequest;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.Organization;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.auth.api.authentication.request.UserReq;

import java.util.List;
import java.util.Set;

/** UserAdaptor defines some interfaces for obtaining user and organization information */
public interface UserAdaptor {
    List<String> getUserNames();

    List<User> getUserList();

    List<Organization> getOrganizationTree();

    void register(UserReq userReq);

    String login(UserReq userReq, HttpServletRequest request);

    String login(UserReq userReq, String appKey);

    List<User> getUserByOrg(String key);

    Set<String> getUserAllOrgId(String userName);
}
