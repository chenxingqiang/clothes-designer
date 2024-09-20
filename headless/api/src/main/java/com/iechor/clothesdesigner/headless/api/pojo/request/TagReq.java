package com.iechor.clothesdesigner.headless.api.pojo.request;

import javax.validation.constraints.NotNull;

import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import com.iechor.clothesdesigner.headless.api.pojo.enums.TagDefineType;
import lombok.Data;

@Data
public class TagReq extends RecordInfo {

    private Long id;

    @NotNull private TagDefineType tagDefineType;

    @NotNull private Long itemId;
}
