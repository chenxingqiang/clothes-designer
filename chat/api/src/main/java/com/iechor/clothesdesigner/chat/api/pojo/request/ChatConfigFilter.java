package com.iechor.clothesdesigner.chat.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChatConfigFilter {

    private Long id;
    private Long modelId;
    private StatusEnum status = StatusEnum.ONLINE;
}
