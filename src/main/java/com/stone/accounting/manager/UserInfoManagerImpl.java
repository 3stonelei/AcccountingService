package com.stone.accounting.manager;

import com.stone.accounting.converter.p2c.UserInfoP2CConverter;
import com.stone.accounting.dao.UserInfoDao;
import com.stone.accounting.exception.ResourceNotFoundException;
import com.stone.accounting.model.common.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implements UserInfoManager.
 */
@Service
public class UserInfoManagerImpl implements UserInfoManager {
    private final UserInfoDao userInfoDao;

    private final UserInfoP2CConverter userInfoP2CConverter;

    @Autowired
    public UserInfoManagerImpl(UserInfoDao userInfoDao, UserInfoP2CConverter userInfoP2CConverter) {
        this.userInfoDao = userInfoDao;
        this.userInfoP2CConverter = userInfoP2CConverter;
    }

    @Override
    public UserInfo getUserById(Long id) {
        Optional.ofNullable(userInfoDao.getUserById(id))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("there is no user %s", id)));
        com.stone.accounting.model.persistence.UserInfo userInfo = userInfoDao.getUserById(id);
        return userInfoP2CConverter.convert(userInfo);
    }
}
