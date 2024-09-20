package com.iechor.clothesdesigner.chat.server.config;

import com.iechor.clothesdesigner.chat.api.pojo.request.ChatAggConfigReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatDetailConfigReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.RecommendedQuestionReq;
import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import com.iechor.clothesdesigner.common.pojo.enums.StatusEnum;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ChatConfig {

    /** database auto-increment primary key */
    private Long id;

    private Long modelId;

    /** the chatDetailConfig about the model */
    private ChatDetailConfigReq chatDetailConfig;

    /** the chatAggConfig about the model */
    private ChatAggConfigReq chatAggConfig;

    private List<RecommendedQuestionReq> recommendedQuestions;

    /** available status */
    private StatusEnum status;

    /** about createdBy, createdAt, updatedBy, updatedAt */
    private RecordInfo recordInfo;
}
