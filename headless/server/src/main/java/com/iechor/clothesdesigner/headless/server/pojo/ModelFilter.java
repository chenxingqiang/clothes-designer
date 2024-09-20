package com.iechor.clothesdesigner.headless.server.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import lombok.Data;

import java.util.List;

@Data
public class ModelFilter extends MetaFilter {

    private Long databaseId;

    private List<Long> domainIds;

    private Boolean includesDetail = true;

    public ModelFilter() {}

    public ModelFilter(Boolean includesDetail) {
        this.includesDetail = includesDetail;
    }

    public ModelFilter(Boolean includesDetail, List<Long> ids) {
        this.includesDetail = includesDetail;
        this.setIds(ids);
    }
}
