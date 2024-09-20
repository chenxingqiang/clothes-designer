package com.iechor.clothesdesigner.common.pojo.enums;

/** Enumerate query types supported by clothesdesigner. */
public enum QueryType {
    /** queries with metric calculation (optionally slice and dice by dimensions) */
    METRIC,
    /** queries with tag-based entity targeting */
    DETAIL,
    /** queries with ID-based entity selection */
    ID;

    public boolean isNativeAggQuery() {
        return DETAIL.equals(this);
    }
}
