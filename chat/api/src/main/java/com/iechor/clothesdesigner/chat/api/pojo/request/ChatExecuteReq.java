package com.iechor.clothesdesigner.chat.api.pojo.request;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatExecuteReq {

    private User user;
    private Integer agentId;
    private Long queryId;
    private Integer chatId;
    private int parseId;
    private String queryText;
    private boolean saveAnswer;
}
