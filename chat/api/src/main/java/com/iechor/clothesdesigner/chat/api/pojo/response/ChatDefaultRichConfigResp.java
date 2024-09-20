package com.iechor.clothesdesigner.chat.api.pojo.response;

import com.iechor.clothesdesigner.common.pojo.Constants;
import com.iechor.clothesdesigner.common.pojo.enums.TimeMode;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaElement;
import lombok.Data;

import java.util.List;

@Data
public class ChatDefaultRichConfigResp {

    private List<SchemaElement> dimensions;
    private List<SchemaElement> metrics;

    /** default time span unit */
    private Integer unit = 1;

    /** default time type: DAY, WEEK, MONTH, YEAR */
    private String period = Constants.DAY;

    private TimeMode timeMode;
}
