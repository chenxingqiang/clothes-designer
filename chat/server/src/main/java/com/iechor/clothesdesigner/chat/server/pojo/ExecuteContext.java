package com.iechor.clothesdesigner.chat.server.pojo;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.chat.server.agent.Agent;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import lombok.Data;

@Data
public class ExecuteContext {

    private User user;
    private String queryText;
    private Agent agent;
    private Integer chatId;
    private Long queryId;
    private boolean saveAnswer;
    private SemanticParseInfo parseInfo;
}
