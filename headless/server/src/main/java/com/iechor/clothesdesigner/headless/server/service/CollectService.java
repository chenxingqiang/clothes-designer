package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.enums.TypeEnums;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.CollectDO;

import java.util.List;

/**
 * @author yannsu
 */
public interface CollectService {
    Boolean collect(User user, CollectDO collectDO);

    Boolean unCollect(User user, Long id);

    Boolean unCollect(User user, CollectDO collectDO);

    List<CollectDO> getCollectionList(String username);

    List<CollectDO> getCollectionList(String username, TypeEnums typeEnums);
}
