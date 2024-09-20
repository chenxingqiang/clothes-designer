package com.iechor.clothesdesigner.headless.core.pojo;

import com.google.common.collect.Lists;
import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import com.iechor.clothesdesigner.common.util.AESEncryptionUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Database extends RecordInfo {

    private Long id;

    private Long domainId;

    private String name;

    private String description;

    private String version;

    private String url;

    private String username;

    private String password;

    private String database;

    private String schema;
    /** mysql,clickhouse */
    private String type;

    private List<String> admins = Lists.newArrayList();

    private List<String> viewers = Lists.newArrayList();

    public String passwordDecrypt() {
        return AESEncryptionUtil.aesDecryptECB(password);
    }
}
