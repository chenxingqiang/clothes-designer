package com.iechor.clothesdesigner.headless.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.enums.EventType;
import lombok.Data;

import java.util.List;

@Data
public class MetaBatchReq {

    private List<Long> ids;

    private List<String> bizNames;

    private List<Long> modelIds;

    /** 最后变更的状态 */
    private Integer status;

    /** 批量执行分类信息 */
    private EventType type;

    private List<String> classifications;

    private Integer sensitiveLevel;
}
