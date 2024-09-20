package com.iechor.clothesdesigner.headless.server.processor;

import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;

/** A ParseResultProcessor wraps things up before returning results to users in parse stage. */
public interface ResultProcessor {
    void process(ParseResp parseResp, ChatQueryContext chatQueryContext);
}
