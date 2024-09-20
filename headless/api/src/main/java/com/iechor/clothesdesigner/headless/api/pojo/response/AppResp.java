package com.iechor.clothesdesigner.headless.api.pojo.response;

import com.google.common.collect.Lists;
import com.iechor.clothesdesigner.common.pojo.RecordInfo;
import com.iechor.clothesdesigner.headless.api.pojo.AppConfig;
import com.iechor.clothesdesigner.headless.api.pojo.Item;
import com.iechor.clothesdesigner.headless.api.pojo.enums.AppStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class AppResp extends RecordInfo {

    private Integer id;

    private String name;

    private String description;

    private AppStatus appStatus;

    private AppConfig config;

    private Date endDate;

    private Integer qps;

    private List<String> owners;

    private boolean hasAdminRes;

    public void setOwner(String owner) {
        if (StringUtils.isBlank(owner)) {
            owners = Lists.newArrayList();
            return;
        }
        owners = Arrays.asList(owner.split(","));
    }

    public Set<Item> allItems() {
        Set<Item> itemSet = new HashSet<>();
        for (Item item : config.getItems()) {
            itemSet.add(item);
            itemSet.addAll(item.getRelateItems());
        }
        return itemSet;
    }
}
