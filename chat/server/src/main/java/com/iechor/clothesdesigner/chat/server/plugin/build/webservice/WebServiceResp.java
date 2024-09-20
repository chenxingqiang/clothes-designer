package com.iechor.clothesdesigner.chat.server.plugin.build.webservice;

import com.iechor.clothesdesigner.chat.server.plugin.build.WebBase;
import lombok.Data;

@Data
public class WebServiceResp {

    private WebBase webBase;

    private Object result;
}
