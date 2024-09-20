package com.iechor.clothesdesigner.headless.chat.query;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.DataSetSchema;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.request.SemanticQueryReq;
import org.apache.calcite.sql.parser.SqlParseException;

/** A semantic query executes specific type of query based on the results of semantic parsing. */
public interface SemanticQuery {
    String getQueryMode();

    SemanticQueryReq buildSemanticQueryReq() throws SqlParseException;

    void initS2Sql(DataSetSchema dataSetSchema, User user);

    SemanticParseInfo getParseInfo();

    void setParseInfo(SemanticParseInfo parseInfo);
}
