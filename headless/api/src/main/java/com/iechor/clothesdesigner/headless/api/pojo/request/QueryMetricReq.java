package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.google.common.collect.Lists;
import com.iechor.clothesdesigner.common.pojo.DateConf;
import com.iechor.clothesdesigner.common.pojo.Filter;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QueryMetricReq {

    private Long domainId;

    private List<Long> metricIds = Lists.newArrayList();

    private List<String> metricNames = Lists.newArrayList();

    private List<Long> dimensionIds = Lists.newArrayList();

    private List<String> dimensionNames = Lists.newArrayList();

    private List<Filter> filters = Lists.newArrayList();

    private DateConf dateInfo = new DateConf();

    private Long limit = 2000L;

    private boolean innerLayerNative = false;
}
