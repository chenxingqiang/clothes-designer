package com.iechor.clothesdesigner.headless.api.pojo.response;

import com.iechor.clothesdesigner.headless.api.pojo.SchemaMapInfo;
import lombok.Data;

@Data
public class MapResp {

    private final String queryText;

    private SchemaMapInfo mapInfo = new SchemaMapInfo();

    public MapResp(String queryText) {
        this.queryText = queryText;
    }
}
