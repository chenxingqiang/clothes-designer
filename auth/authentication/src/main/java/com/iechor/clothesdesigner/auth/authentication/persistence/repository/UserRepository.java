package com.iechor.clothesdesigner.auth.authentication.persistence.repository;

import com.iechor.clothesdesigner.auth.authentication.persistence.dataobject.UserDO;

import java.util.List;

public interface UserRepository {
    List<UserDO> getUserList();

    void addUser(UserDO userDO);

    UserDO getUser(String name);
}
