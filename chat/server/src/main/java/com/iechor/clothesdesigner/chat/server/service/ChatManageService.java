package com.iechor.clothesdesigner.chat.server.service;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatExecuteReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatParseReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.PageQueryInfoReq;
import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResp;
import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResult;
import com.iechor.clothesdesigner.chat.api.pojo.response.ShowCaseResp;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatDO;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatParseDO;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatQueryDO;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;

import java.util.List;

public interface ChatManageService {
    Long addChat(User user, String chatName, Integer agentId);

    List<ChatDO> getAll(String userName, Integer agentId);

    boolean updateChatName(Long chatId, String chatName, String userName);

    boolean updateFeedback(Integer id, Integer score, String feedback);

    boolean updateChatIsTop(Long chatId, int isTop);

    Boolean deleteChat(Long chatId, String userName);

    PageInfo<QueryResp> queryInfo(PageQueryInfoReq pageQueryInfoReq, long chatId);

    void createChatQuery(ChatParseReq chatParseReq, ParseResp parseResp);

    QueryResp getChatQuery(Long queryId);

    List<QueryResp> getChatQueries(Integer chatId);

    ShowCaseResp queryShowCase(PageQueryInfoReq pageQueryInfoReq, int agentId);

    ChatQueryDO saveQueryResult(ChatExecuteReq chatExecuteReq, QueryResult queryResult);

    int updateQuery(ChatQueryDO chatQueryDO);

    void updateParseCostTime(ParseResp parseResp);

    List<ChatParseDO> batchAddParse(ChatParseReq chatParseReq, ParseResp parseResult);

    SemanticParseInfo getParseInfo(Long questionId, int parseId);
}
