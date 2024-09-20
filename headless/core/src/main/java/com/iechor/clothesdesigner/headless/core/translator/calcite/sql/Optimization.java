package com.iechor.clothesdesigner.headless.core.translator.calcite.sql;

import com.iechor.clothesdesigner.headless.core.translator.calcite.schema.SemanticSchema;

public interface Optimization {
    public void visit(SemanticSchema semanticSchema);
}
