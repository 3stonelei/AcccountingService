package com.stone.accounting.converter.c2s;

import com.google.common.base.Converter;
import com.stone.accounting.model.common.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author stone
 * @date 2022/11/15-@15:03
 */
@Component
public class UserInfoC2SConverter extends Converter<UserInfo, com.stone.accounting.model.service.UserInfo> {
    @Override
    protected com.stone.accounting.model.service.UserInfo doForward(UserInfo userInfo) {
        return new com.stone.accounting.model.service.UserInfo(userInfo.getId(), userInfo.getUsername(), userInfo.getPassword());
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
