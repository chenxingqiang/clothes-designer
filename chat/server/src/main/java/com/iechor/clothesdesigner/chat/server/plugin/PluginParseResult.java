package com.iechor.clothesdesigner.chat.server.plugin;

import com.iechor.clothesdesigner.headless.api.pojo.request.QueryFilters;
import lombok.Data;

@Data
public class PluginParseResult {

    private ChatPlugin plugin;
    private QueryFilters queryFilters;
    private double distance;
    private String queryText;
}
