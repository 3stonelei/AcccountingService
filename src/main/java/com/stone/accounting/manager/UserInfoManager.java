package com.stone.accounting.manager;

import com.stone.accounting.model.common.UserInfo;

/**
 * @author stone
 * @date 2022/11/14-@23:06
 */
public interface UserInfoManager {
    UserInfo getUserById(Long id);
}
