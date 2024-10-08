package com.iechor.clothesdesigner.headless.server.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.enums.TagDefineType;
import lombok.Data;

import java.util.List;

@Data
public class TagFilter extends MetaFilter {

    private List<Long> itemIds;
    private TagDefineType tagDefineType;
    private boolean hasCollect;
}
