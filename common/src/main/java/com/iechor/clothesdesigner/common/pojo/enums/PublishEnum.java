package com.iechor.clothesdesigner.common.pojo.enums;

public enum PublishEnum {
    UN_PUBLISHED(0),
    PUBLISHED(1);

    private Integer code;

    PublishEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
