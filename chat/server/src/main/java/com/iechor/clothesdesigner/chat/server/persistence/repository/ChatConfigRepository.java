package com.iechor.clothesdesigner.chat.server.persistence.repository;

import com.iechor.clothesdesigner.chat.api.pojo.request.ChatConfigFilter;
import com.iechor.clothesdesigner.chat.api.pojo.response.ChatConfigResp;
import com.iechor.clothesdesigner.chat.server.config.ChatConfig;

import java.util.List;

public interface ChatConfigRepository {
    Long createConfig(ChatConfig chaConfig);

    Long updateConfig(ChatConfig chaConfig);

    List<ChatConfigResp> getChatConfig(ChatConfigFilter filter);

    ChatConfigResp getConfigByModelId(Long modelId);
}
