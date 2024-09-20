package com.iechor.clothesdesigner.headless.server.persistence.mapper;

import com.iechor.clothesdesigner.headless.api.pojo.QueryStat;
import com.iechor.clothesdesigner.headless.api.pojo.request.ItemUseReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatMapper {
    Boolean createRecord(QueryStat queryStatInfo);

    List<QueryStat> getStatInfo(ItemUseReq itemUseCommend);
}
