package com.iechor.clothesdesigner.headless.api.pojo.response;

import javax.validation.constraints.NotNull;

import com.iechor.clothesdesigner.headless.api.pojo.ActionInfo;
import com.iechor.clothesdesigner.headless.api.pojo.RuleInfo;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaItem;
import com.iechor.clothesdesigner.headless.api.pojo.enums.QueryRuleType;
import lombok.Data;

import java.util.Map;

@Data
public class QueryRuleResp extends SchemaItem {

    /** dataSetID */
    private Long dataSetId;

    /** 规则的优先级, 1-低,2-中,3-高 */
    private Integer priority = 1;

    /** 规则类型 */
    @NotNull private QueryRuleType ruleType;

    /** 具体规则信息 */
    @NotNull private RuleInfo rule;

    /** 规则输出信息 */
    private ActionInfo action;

    /** 扩展信息 */
    private Map<String, String> ext;
}
