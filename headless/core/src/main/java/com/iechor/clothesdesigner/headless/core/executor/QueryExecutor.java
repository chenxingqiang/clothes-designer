package com.iechor.clothesdesigner.headless.core.executor;

import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import com.iechor.clothesdesigner.headless.core.pojo.QueryStatement;

/** QueryExecutor submits SQL to the database engine and performs acceleration if necessary. */
public interface QueryExecutor {
    boolean accept(QueryStatement queryStatement);

    SemanticQueryResp execute(QueryStatement queryStatement);
}
