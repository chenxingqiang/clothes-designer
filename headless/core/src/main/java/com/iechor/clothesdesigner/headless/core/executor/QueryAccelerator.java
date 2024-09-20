package com.iechor.clothesdesigner.headless.core.executor;

import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import com.iechor.clothesdesigner.headless.core.pojo.QueryStatement;

/**
 * customize various query media ( like duckDb redis) to improved query performance check ok and
 * query successful , return SemanticQueryResp to interface immediately
 */
public interface QueryAccelerator {
    boolean reload();

    boolean check(QueryStatement queryStatement);

    SemanticQueryResp query(QueryStatement queryStatement);
}
