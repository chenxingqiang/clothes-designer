package com.iechor.clothesdesigner.auth.authentication.persistence.repository.impl;

import com.iechor.clothesdesigner.auth.authentication.persistence.dataobject.UserDO;
import com.iechor.clothesdesigner.auth.authentication.persistence.dataobject.UserDOExample;
import com.iechor.clothesdesigner.auth.authentication.persistence.mapper.UserDOMapper;
import com.iechor.clothesdesigner.auth.authentication.persistence.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    private UserDOMapper userDOMapper;

    public UserRepositoryImpl(UserDOMapper userDOMapper) {
        this.userDOMapper = userDOMapper;
    }

    @Override
    public List<UserDO> getUserList() {
        return userDOMapper.selectByExample(new UserDOExample());
    }

    @Override
    public void addUser(UserDO userDO) {
        userDOMapper.insert(userDO);
    }

    @Override
    public UserDO getUser(String name) {
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andNameEqualTo(name);
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        Optional<UserDO> userDOOptional = userDOS.stream().findFirst();
        return userDOOptional.orElse(null);
    }
}
