package com.iechor.clothesdesigner.headless.server.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.QueryRuleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryRuleMapper extends BaseMapper<QueryRuleDO> {}
