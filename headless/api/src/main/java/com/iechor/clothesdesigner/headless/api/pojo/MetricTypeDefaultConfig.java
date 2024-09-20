package com.iechor.clothesdesigner.headless.api.pojo;

import com.iechor.clothesdesigner.common.pojo.Constants;
import com.iechor.clothesdesigner.common.pojo.enums.TimeMode;
import lombok.Data;

@Data
public class MetricTypeDefaultConfig {

    private TimeDefaultConfig timeDefaultConfig =
            new TimeDefaultConfig(7, Constants.DAY, TimeMode.RECENT);
}
