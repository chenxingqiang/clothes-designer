package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.DateConf;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaElement;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class QueryDataReq {

    private User user;
    private Set<SchemaElement> metrics = new HashSet<>();
    private Set<SchemaElement> dimensions = new HashSet<>();
    private Set<QueryFilter> dimensionFilters = new HashSet<>();
    private Set<QueryFilter> metricFilters = new HashSet<>();
    private DateConf dateInfo;
    private Long queryId;
    private SemanticParseInfo parseInfo;
}
