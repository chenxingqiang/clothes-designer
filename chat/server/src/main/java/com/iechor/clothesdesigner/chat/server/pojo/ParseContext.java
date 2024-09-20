package com.iechor.clothesdesigner.chat.server.pojo;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.chat.server.agent.Agent;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaMapInfo;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryFilters;
import lombok.Data;

@Data
public class ParseContext {

    private User user;
    private String queryText;
    private Agent agent;
    private Integer chatId;
    private QueryFilters queryFilters;
    private boolean saveAnswer = true;
    private SchemaMapInfo mapInfo;

    public boolean enableNL2SQL() {
        if (agent == null) {
            return true;
        }
        return agent.containsNL2SQLTool();
    }
}
