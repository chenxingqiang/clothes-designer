package com.iechor.clothesdesigner.chat.server.parser;

import com.iechor.clothesdesigner.chat.server.pojo.ParseContext;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;

public interface ChatQueryParser {
    void parse(ParseContext parseContext, ParseResp parseResp);
}
