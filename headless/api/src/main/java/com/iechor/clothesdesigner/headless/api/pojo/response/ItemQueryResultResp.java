package com.iechor.clothesdesigner.headless.api.pojo.response;

import com.iechor.clothesdesigner.headless.api.pojo.SingleItemQueryResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ItemQueryResultResp {

    private List<SingleItemQueryResult> results;
}
