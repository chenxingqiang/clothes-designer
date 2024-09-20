package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.TagObjectReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.TagObjectResp;
import com.iechor.clothesdesigner.headless.server.pojo.TagObjectFilter;

import java.util.List;
import java.util.Map;

public interface TagObjectService {
    TagObjectResp create(TagObjectReq tagObjectReq, User user) throws Exception;

    TagObjectResp update(TagObjectReq tagObjectReq, User user);

    Boolean delete(Long id, User user) throws Exception;

    Boolean delete(Long id, User user, Boolean checkStatus) throws Exception;

    TagObjectResp getTagObject(Long id, User user);

    List<TagObjectResp> getTagObjects(TagObjectFilter filter, User user);

    Map<Long, TagObjectResp> getAllTagObjectMap();
}
