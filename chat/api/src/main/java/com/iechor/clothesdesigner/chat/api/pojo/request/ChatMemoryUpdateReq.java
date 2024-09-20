package com.iechor.clothesdesigner.chat.api.pojo.request;

import javax.validation.constraints.NotNull;

import com.iechor.clothesdesigner.chat.api.pojo.enums.MemoryReviewResult;
import com.iechor.clothesdesigner.chat.api.pojo.enums.MemoryStatus;
import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import lombok.Data;

@Data
public class ChatMemoryUpdateReq extends RecordInfo {

    @NotNull(message = "id不可为空")
    private Long id;

    private String dbSchema;

    private String s2sql;

    private MemoryStatus status;

    private MemoryReviewResult humanReviewRet;

    private String humanReviewCmt;
}
