package com.iechor.clothesdesigner.headless.core.translator.calcite.planner;

import com.iechor.clothesdesigner.headless.api.pojo.enums.AggOption;
import com.iechor.clothesdesigner.headless.api.pojo.enums.EngineType;
import com.iechor.clothesdesigner.headless.core.pojo.QueryStatement;

/** parse and generate SQL and other execute information */
public interface Planner {
    public void explain(QueryStatement queryStatement, AggOption aggOption) throws Exception;

    public String getSql(EngineType enginType);

    public String getSourceId();

    public String simplify(String sql, EngineType engineType);
}
