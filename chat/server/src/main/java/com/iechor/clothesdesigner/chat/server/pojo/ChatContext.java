package com.iechor.clothesdesigner.chat.server.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import lombok.Data;

@Data
public class ChatContext {

    private Integer chatId;
    private String queryText;
    private SemanticParseInfo parseInfo = new SemanticParseInfo();
    private String user;
}
