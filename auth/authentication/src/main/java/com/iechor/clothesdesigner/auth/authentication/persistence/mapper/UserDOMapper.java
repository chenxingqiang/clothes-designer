package com.iechor.clothesdesigner.auth.authentication.persistence.mapper;

import com.iechor.clothesdesigner.auth.authentication.persistence.dataobject.UserDO;
import com.iechor.clothesdesigner.auth.authentication.persistence.dataobject.UserDOExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDOMapper {
    /**
     * @mbg.generated
     */
    int insert(UserDO record);

    /**
     * @mbg.generated
     */
    List<UserDO> selectByExample(UserDOExample example);
}
