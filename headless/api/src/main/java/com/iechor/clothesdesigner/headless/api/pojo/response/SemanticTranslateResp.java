package com.iechor.clothesdesigner.headless.api.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SemanticTranslateResp implements Serializable {

    private String querySQL;

    private boolean isOk;

    private String errMsg;
}
