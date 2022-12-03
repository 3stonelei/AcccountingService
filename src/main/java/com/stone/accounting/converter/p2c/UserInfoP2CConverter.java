package com.stone.accounting.converter.p2c;

import com.google.common.base.Converter;
import com.stone.accounting.model.persistence.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author stone
 * @date 2022/11/15-@15:06
 */
@Component
public class UserInfoP2CConverter extends Converter<UserInfo, com.stone.accounting.model.common.UserInfo> {
    @Override
    protected com.stone.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return new com.stone.accounting.model.common.UserInfo(userInfo.getId(),userInfo.getUsername(),userInfo.getSalt(),userInfo.getPassword());
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
