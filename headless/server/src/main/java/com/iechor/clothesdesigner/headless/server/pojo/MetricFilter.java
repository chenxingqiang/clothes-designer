package com.iechor.clothesdesigner.headless.server.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import lombok.Data;

@Data
public class MetricFilter extends MetaFilter {

    private String type;

    private String userName;

    private Integer isPublish;
}
