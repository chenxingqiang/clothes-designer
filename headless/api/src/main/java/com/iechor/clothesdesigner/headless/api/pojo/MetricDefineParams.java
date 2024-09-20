package com.iechor.clothesdesigner.headless.api.pojo;

import lombok.Data;

@Data
public abstract class MetricDefineParams {

    private String expr;

    private String filterSql;
}
