package com.iechor.clothesdesigner.headless.server.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.TermDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermMapper extends BaseMapper<TermDO> {}
