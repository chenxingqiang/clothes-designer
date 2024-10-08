package com.iechor.clothesdesigner.chat.server.persistence.mapper;

import com.iechor.clothesdesigner.chat.server.persistence.dataobject.StatisticsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    boolean batchSaveStatistics(@Param("list") List<StatisticsDO> list);
}
