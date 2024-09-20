package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.ColumnOrder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MetricQueryReq {

    private List<String> metrics;
    private List<String> dimensions;
    private Map<String, String> variables;
    private String where;
    private Long limit;
    private List<ColumnOrder> order;
    private boolean nativeQuery = false;
}
