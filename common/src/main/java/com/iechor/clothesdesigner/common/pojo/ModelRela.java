package com.iechor.clothesdesigner.common.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ModelRela extends RecordInfo {

    private Long id;

    private Long domainId;

    private Long fromModelId;

    private Long toModelId;

    // left join, inner join, right join, outer join
    private String joinType;

    private List<JoinCondition> joinConditions;
}
