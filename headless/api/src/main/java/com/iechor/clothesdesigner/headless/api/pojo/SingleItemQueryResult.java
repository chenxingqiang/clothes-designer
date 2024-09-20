package com.iechor.clothesdesigner.headless.api.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import lombok.Data;

@Data
public class SingleItemQueryResult {

    private Item item;

    private SemanticQueryResp result;
}
