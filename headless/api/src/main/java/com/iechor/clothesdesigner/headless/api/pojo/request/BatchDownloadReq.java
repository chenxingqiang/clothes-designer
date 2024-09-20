package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.DateConf;
import lombok.Data;

import java.util.List;

@Data
public class BatchDownloadReq {

    private List<Long> metricIds;

    private DateConf dateInfo;

    private boolean isTransform = true;
}
