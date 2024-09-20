package com.iechor.clothesdesigner.chat.api.pojo.request;

import com.iechor.clothesdesigner.common.pojo.PageBaseReq;
import lombok.Data;

@Data
public class PageMemoryReq extends PageBaseReq {

    private ChatMemoryFilter chatMemoryFilter = new ChatMemoryFilter();
}
