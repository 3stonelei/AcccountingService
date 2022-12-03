package com.stone.accounting.dao.impl;

import com.stone.accounting.dao.UserInfoDAO;
import com.stone.accounting.dao.mapper.UserInfoMapper;
import com.stone.accounting.model.persistence.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author stone
 * @date 2022/11/14-@23:07
 */
@Repository
@RequiredArgsConstructor
public class UserInfoDAOImpl implements UserInfoDAO {


    private final UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserById(Long id) {
        return userInfoMapper.getUserById(id);
    }
}
