package com.iechor.clothesdesigner.chat.server.processor.parse;

import com.iechor.clothesdesigner.chat.server.pojo.ParseContext;
import com.iechor.clothesdesigner.chat.server.processor.ResultProcessor;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;

/** A ParseResultProcessor wraps things up before returning parsing results to the users. */
public interface ParseResultProcessor extends ResultProcessor {
    void process(ParseContext parseContext, ParseResp parseResp);
}
