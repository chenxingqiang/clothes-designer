package com.iechor.clothesdesigner.headless.api.pojo.request;

import lombok.Data;

@Data
public class ColumnReq {

    private Long databaseId;
    private String sql;
}
