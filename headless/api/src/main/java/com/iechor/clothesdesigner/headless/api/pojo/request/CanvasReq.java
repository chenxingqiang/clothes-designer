package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import lombok.Data;

@Data
public class CanvasReq extends RecordInfo {

    private Long id;

    private Long domainId;

    private String type;

    private String config;
}
