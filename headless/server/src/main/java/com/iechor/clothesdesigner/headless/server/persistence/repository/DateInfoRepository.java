package com.iechor.clothesdesigner.headless.server.persistence.repository;

import com.iechor.clothesdesigner.headless.api.pojo.ItemDateFilter;
import com.iechor.clothesdesigner.headless.api.pojo.request.DateInfoReq;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.DateInfoDO;

import java.util.List;

public interface DateInfoRepository {
    Integer upsertDateInfo(List<DateInfoReq> dateInfoReqs);

    List<DateInfoDO> getDateInfos(ItemDateFilter itemDateFilter);
}
