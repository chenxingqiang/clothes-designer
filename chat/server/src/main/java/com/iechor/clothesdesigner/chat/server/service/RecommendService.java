package com.iechor.clothesdesigner.chat.server.service;

import com.iechor.clothesdesigner.chat.api.pojo.request.RecommendReq;
import com.iechor.clothesdesigner.chat.api.pojo.response.RecommendQuestionResp;
import com.iechor.clothesdesigner.chat.api.pojo.response.RecommendResp;

import java.util.List;

/** * Recommend Service */
public interface RecommendService {
    RecommendResp recommend(RecommendReq recommendReq, Long limit);

    RecommendResp recommendMetricMode(RecommendReq recommendReq, Long limit);

    List<RecommendQuestionResp> recommendQuestion(Long modelId);
}
