package com.iechor.clothesdesigner.auth.api.authorization.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthRes {

    private Long modelId;
    private String name;

    public AuthRes() {}

    public AuthRes(Long modelId, String name) {
        this.modelId = modelId;
        this.name = name;
    }
}
