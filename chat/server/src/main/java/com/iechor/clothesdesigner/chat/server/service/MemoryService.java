package com.iechor.clothesdesigner.chat.server.service;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatMemoryFilter;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatMemoryUpdateReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.PageMemoryReq;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatMemoryDO;

import java.util.List;

public interface MemoryService {
    void createMemory(ChatMemoryDO memory);

    void updateMemory(ChatMemoryUpdateReq chatMemoryUpdateReq, User user);

    void updateMemory(ChatMemoryDO memory);

    void enableMemory(ChatMemoryDO memory);

    void disableMemory(ChatMemoryDO memory);

    PageInfo<ChatMemoryDO> pageMemories(PageMemoryReq pageMemoryReq);

    List<ChatMemoryDO> getMemories(ChatMemoryFilter chatMemoryFilter);

    List<ChatMemoryDO> getMemoriesForLlmReview();
}
