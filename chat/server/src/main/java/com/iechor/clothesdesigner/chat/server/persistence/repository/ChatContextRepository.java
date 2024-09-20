package com.iechor.clothesdesigner.chat.server.persistence.repository;

import com.iechor.clothesdesigner.chat.server.pojo.ChatContext;

public interface ChatContextRepository {
    ChatContext getOrCreateContext(Integer chatId);

    void updateContext(ChatContext chatCtx);
}
