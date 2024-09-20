package com.iechor.clothesdesigner.chat.server.agent;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

@Data
public class RuleParserTool extends NL2SQLTool {

    private List<String> queryModes;

    private List<String> queryTypes;

    public boolean isContainsAllModel() {
        return CollectionUtils.isNotEmpty(dataSetIds) && dataSetIds.contains(-1L);
    }
}
