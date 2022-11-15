package com.stone.accounting.dao.impl;

import com.stone.accounting.dao.UserInfoDAO;
import com.stone.accounting.dao.mapper.UserInfoMapper;
import com.stone.accounting.model.persitence.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author stone
 * @date 2022/11/14-@23:07
 */
@Repository
public class UserInfoDAOImpl implements UserInfoDAO {


    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoDAOImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo getUserById(Long id) {
        return userInfoMapper.getUserById(id);
    }
}
