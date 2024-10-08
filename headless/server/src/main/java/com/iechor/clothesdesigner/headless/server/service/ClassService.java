package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.ClassReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.ClassResp;
import com.iechor.clothesdesigner.headless.server.pojo.ClassFilter;

import java.util.List;

public interface ClassService {
    ClassResp create(ClassReq classReq, User user);

    ClassResp update(ClassReq classReq, User user);

    Boolean delete(Long id, Boolean force, User user) throws Exception;

    List<ClassResp> getClassList(ClassFilter filter, User user);
}
