package com.stone.accounting.dao;

import com.stone.accounting.model.persistence.UserInfo;

/**
 * UserInfoDao.
 */
public interface UserInfoDao {

    UserInfo getUserById(Long id);
}
