package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.headless.api.pojo.enums.TagDefineType;
import lombok.Data;

@Data
public class TagFilterPageReq extends PageSchemaItemReq {

    private Long tagObjectId;

    private TagDefineType tagDefineType;
}
