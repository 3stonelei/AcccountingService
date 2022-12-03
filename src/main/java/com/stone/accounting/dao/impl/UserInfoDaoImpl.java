package com.stone.accounting.dao.impl;

import com.stone.accounting.dao.UserInfoDao;
import com.stone.accounting.dao.mapper.UserInfoMapper;
import com.stone.accounting.model.persistence.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Implements UserInfoDao.
 */
@Repository
@RequiredArgsConstructor
public class UserInfoDaoImpl implements UserInfoDao {


    private final UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserById(Long id) {
        return userInfoMapper.getUserById(id);
    }
}
