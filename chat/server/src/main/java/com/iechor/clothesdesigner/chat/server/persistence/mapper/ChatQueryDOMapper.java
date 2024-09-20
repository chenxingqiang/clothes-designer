package com.iechor.clothesdesigner.chat.server.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatQueryDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatQueryDOMapper extends BaseMapper<ChatQueryDO> {}
