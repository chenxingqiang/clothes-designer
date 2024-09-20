package com.iechor.clothesdesigner.headless.core.translator;

import com.iechor.clothesdesigner.headless.core.pojo.QueryStatement;

/**
 * SemanticTranslator converts semantic query statement into SQL statement that can be executed
 * against physical data models.
 */
public interface SemanticTranslator {
    void translate(QueryStatement queryStatement);
}
