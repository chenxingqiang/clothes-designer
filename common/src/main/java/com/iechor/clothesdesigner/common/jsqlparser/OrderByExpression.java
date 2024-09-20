package com.iechor.clothesdesigner.common.jsqlparser;

import lombok.Data;

@Data
public class OrderByExpression {

    private String operator;

    private String fieldName;

    private Object fieldValue;

    private String function;
}
