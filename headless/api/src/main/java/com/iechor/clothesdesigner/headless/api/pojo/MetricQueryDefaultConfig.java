package com.iechor.clothesdesigner.headless.api.pojo;

import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import lombok.Data;

@Data
public class MetricQueryDefaultConfig extends RecordInfo {

    private Long id;

    private Long metricId;

    private String userName;

    // string of queryStruct
    private String defaultConfig;
}
