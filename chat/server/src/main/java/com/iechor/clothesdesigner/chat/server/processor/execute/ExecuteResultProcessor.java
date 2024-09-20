package com.iechor.clothesdesigner.chat.server.processor.execute;

import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResult;
import com.iechor.clothesdesigner.chat.server.pojo.ExecuteContext;
import com.iechor.clothesdesigner.chat.server.processor.ResultProcessor;

/** A ExecuteResultProcessor wraps things up before returning execution results to the users. */
public interface ExecuteResultProcessor extends ResultProcessor {
    void process(ExecuteContext executeContext, QueryResult queryResult);
}
