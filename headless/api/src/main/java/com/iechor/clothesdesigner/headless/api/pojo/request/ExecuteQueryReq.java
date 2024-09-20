package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExecuteQueryReq {
    private User user;
    private Long queryId;
    private String queryText;
    private SemanticParseInfo parseInfo;
    private boolean saveAnswer;
}
