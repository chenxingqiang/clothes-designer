package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.enums.StatusEnum;
import com.iechor.clothesdesigner.common.pojo.enums.TypeEnums;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DictItemFilter {

    private Long id;
    private TypeEnums type;
    private Long itemId;
    private StatusEnum status;
}
