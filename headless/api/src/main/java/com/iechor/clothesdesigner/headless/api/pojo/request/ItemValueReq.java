package com.iechor.clothesdesigner.headless.api.pojo.request;

import javax.validation.constraints.NotNull;

import com.iechor.clothesdesigner.common.pojo.DateConf;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemValueReq {

    @NotNull private Long id;

    private DateConf dateConf;

    private Long limit = 10L;
}
