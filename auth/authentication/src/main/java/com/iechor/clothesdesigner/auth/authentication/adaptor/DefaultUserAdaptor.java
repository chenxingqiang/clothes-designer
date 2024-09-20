package com.iechor.clothesdesigner.auth.authentication.adaptor;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.iechor.clothesdesigner.auth.api.authentication.adaptor.UserAdaptor;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.Organization;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.UserWithPassword;
import com.iechor.clothesdesigner.auth.api.authentication.request.UserReq;
import com.iechor.clothesdesigner.auth.authentication.persistence.dataobject.UserDO;
import com.iechor.clothesdesigner.auth.authentication.persistence.repository.UserRepository;
import com.iechor.clothesdesigner.auth.authentication.utils.UserTokenUtils;
import com.iechor.clothesdesigner.common.util.AESEncryptionUtil;
import com.iechor.clothesdesigner.common.util.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** DefaultUserAdaptor provides a default method to obtain user and organization information */
@Slf4j
public class DefaultUserAdaptor implements UserAdaptor {

    private List<UserDO> getUserDOList() {
        UserRepository userRepository = ContextUtils.getBean(UserRepository.class);
        return userRepository.getUserList();
    }

    private UserDO getUser(String name) {
        UserRepository userRepository = ContextUtils.getBean(UserRepository.class);
        return userRepository.getUser(name);
    }

    @Override
    public List<String> getUserNames() {
        return getUserDOList().stream().map(UserDO::getName).collect(Collectors.toList());
    }

    @Override
    public List<User> getUserList() {
        List<UserDO> userDOS = getUserDOList();
        return userDOS.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public List<Organization> getOrganizationTree() {
        Organization clothesdesigner =
                new Organization(
                        "1", "0", "clothesdesigner", "clothesdesigner", Lists.newArrayList(), true);
        Organization hr =
                new Organization("2", "1", "Hr", "clothesdesigner/Hr", Lists.newArrayList(), false);
        Organization sales =
                new Organization(
                        "3", "1", "Sales", "clothesdesigner/Sales", Lists.newArrayList(), false);
        Organization marketing =
                new Organization(
                        "4",
                        "1",
                        "Marketing",
                        "clothesdesigner/Marketing",
                        Lists.newArrayList(),
                        false);
        List<Organization> subOrganization = Lists.newArrayList(hr, sales, marketing);
        clothesdesigner.setSubOrganizations(subOrganization);
        return Lists.newArrayList(clothesdesigner);
    }

    private User convert(UserDO userDO) {
        User user = new User();
        BeanUtils.copyProperties(userDO, user);
        return user;
    }

    @Override
    public void register(UserReq userReq) {
        UserRepository userRepository = ContextUtils.getBean(UserRepository.class);
        List<String> userDOS = getUserNames();
        if (userDOS.contains(userReq.getName())) {
            throw new RuntimeException(String.format("user %s exist", userReq.getName()));
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userReq, userDO);
        try {
            byte[] salt = AESEncryptionUtil.generateSalt(userDO.getName());
            userDO.setSalt(AESEncryptionUtil.getStringFromBytes(salt));
            userDO.setPassword(AESEncryptionUtil.encrypt(userReq.getPassword(), salt));
        } catch (Exception e) {
            throw new RuntimeException("password encrypt error, please try again");
        }
        userRepository.addUser(userDO);
    }

    @Override
    public String login(UserReq userReq, HttpServletRequest request) {
        UserTokenUtils userTokenUtils = ContextUtils.getBean(UserTokenUtils.class);
        String appKey = userTokenUtils.getAppKey(request);
        return login(userReq, appKey);
    }

    @Override
    public String login(UserReq userReq, String appKey) {
        UserTokenUtils userTokenUtils = ContextUtils.getBean(UserTokenUtils.class);
        try {
            UserWithPassword user = getUserWithPassword(userReq);
            return userTokenUtils.generateToken(user, appKey);
        } catch (Exception e) {
            log.error("", e);
            throw new RuntimeException("password encrypt error, please try again");
        }
    }

    private UserWithPassword getUserWithPassword(UserReq userReq) {
        UserDO userDO = getUser(userReq.getName());
        if (userDO == null) {
            throw new RuntimeException("user not exist,please register");
        }
        try {
            String password =
                    AESEncryptionUtil.encrypt(
                            userReq.getPassword(),
                            AESEncryptionUtil.getBytesFromString(userDO.getSalt()));
            if (userDO.getPassword().equals(password)) {
                UserWithPassword user =
                        UserWithPassword.get(
                                userDO.getId(),
                                userDO.getName(),
                                userDO.getDisplayName(),
                                userDO.getEmail(),
                                userDO.getPassword(),
                                userDO.getIsAdmin());
                return user;
            } else {
                throw new RuntimeException("password not correct, please try again");
            }
        } catch (Exception e) {
            throw new RuntimeException("password encrypt error, please try again");
        }
    }

    @Override
    public List<User> getUserByOrg(String key) {
        return Lists.newArrayList();
    }

    @Override
    public Set<String> getUserAllOrgId(String userName) {
        return Sets.newHashSet();
    }
}
