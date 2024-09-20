package com.iechor.clothesdesigner.chat.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatConfigBaseReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatConfigEditReqReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatConfigFilter;
import com.iechor.clothesdesigner.chat.api.pojo.request.ItemNameVisibilityInfo;
import com.iechor.clothesdesigner.chat.api.pojo.response.ChatConfigResp;
import com.iechor.clothesdesigner.chat.api.pojo.response.ChatConfigRichResp;
import com.iechor.clothesdesigner.chat.server.config.ChatConfig;

import java.util.List;

public interface ConfigService {
    Long addConfig(ChatConfigBaseReq extendBaseCmd, User user);

    Long editConfig(ChatConfigEditReqReq extendEditCmd, User user);

    ItemNameVisibilityInfo getItemNameVisibility(ChatConfig chatConfig);

    List<ChatConfigResp> search(ChatConfigFilter filter, User user);

    ChatConfigRichResp getConfigRichInfo(Long modelId);

    ChatConfigResp fetchConfigByModelId(Long modelId);

    List<ChatConfigRichResp> getAllChatRichConfig();
}
