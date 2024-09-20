package com.iechor.clothesdesigner.chat.server.persistence.repository;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatParseReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.PageQueryInfoReq;
import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResp;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatParseDO;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatQueryDO;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;

import java.util.List;

public interface ChatQueryRepository {
    PageInfo<QueryResp> getChatQuery(PageQueryInfoReq pageQueryInfoCommend, Long chatId);

    QueryResp getChatQuery(Long queryId);

    List<QueryResp> getChatQueries(Integer chatId);

    ChatQueryDO getChatQueryDO(Long queryId);

    List<QueryResp> queryShowCase(PageQueryInfoReq pageQueryInfoCommend, int agentId);

    int updateChatQuery(ChatQueryDO chatQueryDO);

    void updateChatQuery(ChatQueryDO chatQueryDO, UpdateWrapper<ChatQueryDO> updateWrapper);

    Long createChatQuery(ChatParseReq chatParseReq);

    List<ChatParseDO> batchSaveParseInfo(
            ChatParseReq chatParseReq,
            ParseResp parseResult,
            List<SemanticParseInfo> candidateParses);

    ChatParseDO getParseInfo(Long questionId, int parseId);

    List<ChatParseDO> getParseInfoList(List<Long> questionIds);
}
