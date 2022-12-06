package com.stone.accounting.converter.p2c;

import com.google.common.base.Converter;
import com.stone.accounting.model.persistence.UserInfo;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * Persistence UserInfo converter to common UserInfo.
 */
@Component
@EqualsAndHashCode(callSuper = true)
public class UserInfoP2CConverter extends Converter<UserInfo, com.stone.accounting.model.common.UserInfo> {
    @Override
    protected com.stone.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return com.stone.accounting.model.common.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .salt(userInfo.getSalt())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.stone.accounting.model.common.UserInfo userInfo) {
        UserInfo userInfoResult = UserInfo.builder()
                .id(userInfo.getId())
                .password(userInfo.getPassword())
                .username(userInfo.getUsername())
                .salt(userInfo.getSalt())
                .build();

        return userInfoResult;
    }
}
