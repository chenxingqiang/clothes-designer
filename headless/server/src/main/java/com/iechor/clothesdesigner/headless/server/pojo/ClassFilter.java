package com.iechor.clothesdesigner.headless.server.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import lombok.Data;

@Data
public class ClassFilter extends MetaFilter {

    private String type;
    private Long dataSetId;
    private Long classId;
}
