package com.stone.accounting.manager;

import com.stone.accounting.model.common.UserInfo;

/**
 * interface userInfoManager.
 */
public interface UserInfoManager {
    UserInfo getUserById(Long id);
}
