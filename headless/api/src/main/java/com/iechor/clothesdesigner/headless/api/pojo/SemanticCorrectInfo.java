package com.iechor.clothesdesigner.headless.api.pojo;

import com.iechor.clothesdesigner.headless.api.pojo.request.QueryFilters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemanticCorrectInfo {

    private QueryFilters queryFilters;

    private SemanticParseInfo parseInfo;

    private String sql;

    private String preSql;
}
