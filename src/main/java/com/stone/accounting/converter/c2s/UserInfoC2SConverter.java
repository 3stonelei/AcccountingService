package com.stone.accounting.converter.c2s;

import com.google.common.base.Converter;
import com.stone.accounting.model.common.UserInfo;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * Common UserInfo Converter To Service UserInfo.
 */
@Component
@EqualsAndHashCode(callSuper = true)
public class UserInfoC2SConverter extends Converter<UserInfo, com.stone.accounting.model.service.UserInfo> {
    @Override
    protected com.stone.accounting.model.service.UserInfo doForward(UserInfo userInfo) {
        return com.stone.accounting.model.service.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.stone.accounting.model.service.UserInfo userInfo) {
        UserInfo userInfoResult = UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
        return userInfoResult;
    }
}
