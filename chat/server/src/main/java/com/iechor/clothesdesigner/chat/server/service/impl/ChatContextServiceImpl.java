package com.iechor.clothesdesigner.chat.server.service.impl;

import com.iechor.clothesdesigner.chat.server.persistence.repository.ChatContextRepository;
import com.iechor.clothesdesigner.chat.server.pojo.ChatContext;
import com.iechor.clothesdesigner.chat.server.service.ChatContextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatContextServiceImpl implements ChatContextService {

    private ChatContextRepository chatContextRepository;

    public ChatContextServiceImpl(ChatContextRepository chatContextRepository) {
        this.chatContextRepository = chatContextRepository;
    }

    @Override
    public ChatContext getOrCreateContext(Integer chatId) {
        return chatContextRepository.getOrCreateContext(chatId);
    }

    @Override
    public void updateContext(ChatContext chatCtx) {
        log.debug("save ChatContext {}", chatCtx);
        chatContextRepository.updateContext(chatCtx);
    }
}
