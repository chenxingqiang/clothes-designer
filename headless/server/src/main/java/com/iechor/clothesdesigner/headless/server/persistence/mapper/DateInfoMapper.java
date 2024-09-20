package com.iechor.clothesdesigner.headless.server.persistence.mapper;

import com.iechor.clothesdesigner.headless.api.pojo.ItemDateFilter;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.DateInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DateInfoMapper {
    Boolean upsertDateInfo(DateInfoDO dateInfoDO);

    List<DateInfoDO> getDateInfos(ItemDateFilter itemDateFilter);
}
