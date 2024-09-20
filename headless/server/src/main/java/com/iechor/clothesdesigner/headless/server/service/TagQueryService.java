package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.ItemValueReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.ItemValueResp;

public interface TagQueryService {
    ItemValueResp queryTagValue(ItemValueReq itemValueReq, User user) throws Exception;
}
