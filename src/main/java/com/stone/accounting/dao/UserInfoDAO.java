package com.stone.accounting.dao;

import com.stone.accounting.model.persistence.UserInfo;

/**
 * @author stone
 * @date 2022/11/14-@23:07++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *
 */
public interface UserInfoDAO {

    UserInfo getUserById(Long id);
}
