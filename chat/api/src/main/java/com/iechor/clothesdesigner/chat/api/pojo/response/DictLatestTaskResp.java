package com.iechor.clothesdesigner.chat.api.pojo.response;

import com.iechor.clothesdesigner.common.pojo.enums.TaskStatusEnum;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class DictLatestTaskResp {

    private Long dimId;

    private Long id;

    private String name;

    private String description;

    private String command;

    private TaskStatusEnum status;

    private String createdBy;

    private Date createdAt;

    private Long elapsedMs;
}
