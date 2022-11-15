package com.stone.accounting.converter.p2c;

import com.google.common.base.Converter;
import com.stone.accounting.model.persitence.UserInfo;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

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
        UserInfo userInfoResult = new UserInfo();
        userInfoResult.setId(userInfo.getId());
        userInfoResult.setUsername(userInfo.getUsername());
        userInfoResult.setPassword(userInfo.getPassword());
        userInfoResult.setSalt(userInfo.getSalt());

        return userInfoResult;
    }
}
