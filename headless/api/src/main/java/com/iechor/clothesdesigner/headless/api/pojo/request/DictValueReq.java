package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.PageBaseReq;
import com.iechor.clothesdesigner.common.pojo.enums.TypeEnums;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DictValueReq extends PageBaseReq {

    private Long modelId;

    private Long itemId;

    private TypeEnums type = TypeEnums.DIMENSION;
}
