package com.iechor.clothesdesigner.chat.api.pojo.response;

import com.iechor.clothesdesigner.headless.api.pojo.SchemaElement;
import lombok.Data;

import java.util.List;

@Data
public class EntityRichInfoResp {

    /** entity alias */
    private List<String> names;

    private SchemaElement dimItem;
}
