package com.iechor.clothesdesigner.chat.api.pojo.request;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaMapInfo;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryFilters;
import lombok.Data;

@Data
public class ChatParseReq {

    private String queryText;
    private Integer chatId;
    private Integer agentId;
    private Integer topN = 10;
    private User user;
    private QueryFilters queryFilters;
    private boolean saveAnswer = true;
    private SchemaMapInfo mapInfo = new SchemaMapInfo();
}
