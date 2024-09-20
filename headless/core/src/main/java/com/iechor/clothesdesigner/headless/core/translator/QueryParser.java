package com.iechor.clothesdesigner.headless.core.translator;

import com.iechor.clothesdesigner.headless.api.pojo.enums.AggOption;
import com.iechor.clothesdesigner.headless.core.pojo.QueryStatement;

/** A query parser generates physical SQL for the QueryStatement. */
public interface QueryParser {
    void parse(QueryStatement queryStatement, AggOption aggOption) throws Exception;
}
