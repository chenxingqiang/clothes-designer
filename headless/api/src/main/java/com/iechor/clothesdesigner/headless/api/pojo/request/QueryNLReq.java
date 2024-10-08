package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.config.PromptConfig;
import com.iechor.clothesdesigner.common.pojo.ChatModelConfig;
import com.iechor.clothesdesigner.common.pojo.Text2SQLExemplar;
import com.iechor.clothesdesigner.common.pojo.enums.Text2SQLType;
import com.iechor.clothesdesigner.headless.api.pojo.QueryDataType;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaMapInfo;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.enums.MapModeEnum;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class QueryNLReq {

    private String queryText;
    private Set<Long> dataSetIds = Sets.newHashSet();
    private User user;
    private QueryFilters queryFilters;
    private boolean saveAnswer = true;
    private Text2SQLType text2SQLType = Text2SQLType.RULE_AND_LLM;
    private MapModeEnum mapModeEnum = MapModeEnum.STRICT;
    private SchemaMapInfo mapInfo = new SchemaMapInfo();
    private QueryDataType queryDataType = QueryDataType.ALL;
    private ChatModelConfig modelConfig;
    private PromptConfig promptConfig;
    private List<Text2SQLExemplar> dynamicExemplars = Lists.newArrayList();
    private SemanticParseInfo contextParseInfo;
}
