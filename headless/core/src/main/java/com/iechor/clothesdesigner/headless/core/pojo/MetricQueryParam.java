package com.iechor.clothesdesigner.headless.core.pojo;

import com.iechor.clothesdesigner.common.pojo.ColumnOrder;
import lombok.Data;

import java.util.List;

@Data
public class MetricQueryParam {

    private List<String> metrics;
    private List<String> dimensions;
    private String where;
    private Long limit;
    private List<ColumnOrder> order;
    private boolean nativeQuery = false;
}
