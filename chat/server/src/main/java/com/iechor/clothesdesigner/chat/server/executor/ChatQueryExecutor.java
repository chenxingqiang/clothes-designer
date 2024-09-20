package com.iechor.clothesdesigner.chat.server.executor;

import com.iechor.clothesdesigner.chat.api.pojo.response.QueryResult;
import com.iechor.clothesdesigner.chat.server.pojo.ExecuteContext;

public interface ChatQueryExecutor {
    QueryResult execute(ExecuteContext executeContext);
}
