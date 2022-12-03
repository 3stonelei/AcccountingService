package com.stone.accounting.manager;

import com.stone.accounting.converter.p2c.UserInfoP2CConverter;
import com.stone.accounting.dao.UserInfoDAO;
import com.stone.accounting.exception.ResourceNotFoundException;
import com.stone.accounting.model.common.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author stone
 * @date 2022/11/14-@23:06
 */
@Service
public class UserInfoManagerImpl implements UserInfoManager {
    private final UserInfoDAO userInfoDAO;

    private final UserInfoP2CConverter userInfoP2CConverter;

    @Autowired
    public UserInfoManagerImpl(UserInfoDAO userInfoDAO, UserInfoP2CConverter userInfoP2CConverter) {
        this.userInfoDAO = userInfoDAO;
        this.userInfoP2CConverter = userInfoP2CConverter;
    }

    @Override
    public UserInfo getUserById(Long id) {
        Optional.ofNullable(userInfoDAO.getUserById(id))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("there is no user %s", id)));
        com.stone.accounting.model.persistence.UserInfo userInfo = userInfoDAO.getUserById(id);
        return userInfoP2CConverter.convert(userInfo);
    }
}
