package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.DictItemFilter;
import com.iechor.clothesdesigner.headless.api.pojo.request.DictItemReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DictItemResp;

import java.util.List;

/** Make relevant settings for the dictionary */
public interface DictConfService {
    DictItemResp addDictConf(DictItemReq itemValueReq, User user);

    DictItemResp editDictConf(DictItemReq itemValueReq, User user);

    List<DictItemResp> queryDictConf(DictItemFilter dictItemFilter, User user);
}
