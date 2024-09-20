package com.iechor.clothesdesigner.headless.api.pojo.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class DimSchemaResp extends DimensionResp {

    private Long useCnt = 0L;

    private List<String> entityAlias;
}
