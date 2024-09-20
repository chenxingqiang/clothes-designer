package com.iechor.clothesdesigner.headless.chat.parser.llm;

import com.iechor.clothesdesigner.headless.api.pojo.request.QueryNLReq;
import com.iechor.clothesdesigner.headless.chat.query.llm.s2sql.LLMReq;
import com.iechor.clothesdesigner.headless.chat.query.llm.s2sql.LLMResp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParseResult {

    private Long dataSetId;

    private LLMReq llmReq;

    private LLMResp llmResp;

    private QueryNLReq request;
}
