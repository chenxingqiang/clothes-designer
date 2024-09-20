package com.iechor.clothesdesigner.headless.server.service;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.DictSingleTaskReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.DictValueReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DictTaskResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.DictValueResp;

/** Manage dictionary tasks */
public interface DictTaskService {
    Long addDictTask(DictSingleTaskReq taskReq, User user);

    Long deleteDictTask(DictSingleTaskReq taskReq, User user);

    Boolean dailyDictTask();

    DictTaskResp queryLatestDictTask(DictSingleTaskReq taskReq, User user);

    PageInfo<DictValueResp> queryDictValue(DictValueReq dictValueReq, User user);

    String queryDictFilePath(DictValueReq dictValueReq, User user);
}
