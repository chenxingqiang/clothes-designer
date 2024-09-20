package com.iechor.clothesdesigner.chat.server.parser;

import com.iechor.clothesdesigner.chat.server.pojo.ParseContext;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;

public class PlainTextParser implements ChatQueryParser {

    @Override
    public void parse(ParseContext parseContext, ParseResp parseResp) {
        if (parseContext.getAgent().containsAnyTool()) {
            return;
        }

        SemanticParseInfo parseInfo = new SemanticParseInfo();
        parseInfo.setQueryMode("PLAIN_TEXT");
        parseResp.getSelectedParses().add(parseInfo);
        parseResp.setState(ParseResp.ParseState.COMPLETED);
    }
}
