package com.iechor.clothesdesigner.headless.server.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import lombok.Data;

import java.util.List;

@Data
public class TagObjectFilter extends MetaFilter {

    private List<Long> domainIds;
}
