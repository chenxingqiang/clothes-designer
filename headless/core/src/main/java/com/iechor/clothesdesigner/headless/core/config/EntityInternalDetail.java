package com.iechor.clothesdesigner.headless.core.config;

import com.iechor.clothesdesigner.headless.api.pojo.response.DimSchemaResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.MetricSchemaResp;
import lombok.Data;

import java.util.List;

@Data
public class EntityInternalDetail {

    List<DimSchemaResp> dimensionList;
    List<MetricSchemaResp> metricList;
}
