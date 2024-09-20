package com.iechor.clothesdesigner.headless.chat.query.llm.s2sql;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.DataSetSchema;
import com.iechor.clothesdesigner.headless.api.pojo.SqlInfo;
import com.iechor.clothesdesigner.headless.chat.query.QueryManager;
import com.iechor.clothesdesigner.headless.chat.query.llm.LLMSemanticQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LLMSqlQuery extends LLMSemanticQuery {

    public static final String QUERY_MODE = "LLM_S2SQL";

    public LLMSqlQuery() {
        QueryManager.register(this);
    }

    @Override
    public String getQueryMode() {
        return QUERY_MODE;
    }

    @Override
    public void initS2Sql(DataSetSchema dataSetSchema, User user) {
        SqlInfo sqlInfo = parseInfo.getSqlInfo();
        sqlInfo.setCorrectedS2SQL(sqlInfo.getParsedS2SQL());
    }
}
