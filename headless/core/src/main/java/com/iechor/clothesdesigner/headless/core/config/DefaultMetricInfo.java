package com.iechor.clothesdesigner.headless.core.config;

import com.iechor.clothesdesigner.common.pojo.Constants;
import lombok.Data;
import lombok.ToString;

/** default metrics about the model */
@ToString
@Data
public class DefaultMetricInfo {

    /** default metrics */
    private Long metricId;

    /** default time span unit */
    private Integer unit = 1;

    /** default time type: day DAY, WEEK, MONTH, YEAR */
    private String period = Constants.DAY;
}
