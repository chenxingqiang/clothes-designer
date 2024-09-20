package com.iechor.clothesdesigner.chat.server.service;

import com.iechor.clothesdesigner.chat.server.pojo.ChatContext;

public interface ChatContextService {
    ChatContext getOrCreateContext(Integer chatId);

    void updateContext(ChatContext chatCtx);
}
