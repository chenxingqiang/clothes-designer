package com.iechor.clothesdesigner.headless.server.persistence.repository;

import com.iechor.clothesdesigner.headless.api.pojo.QueryStat;
import com.iechor.clothesdesigner.headless.api.pojo.request.ItemUseReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.ItemUseResp;

import java.util.List;

public interface StatRepository {
    Boolean createRecord(QueryStat queryStatInfo);

    List<ItemUseResp> getStatInfo(ItemUseReq itemUseCommend);

    List<QueryStat> getQueryStatInfoWithoutCache(ItemUseReq itemUseCommend);
}
