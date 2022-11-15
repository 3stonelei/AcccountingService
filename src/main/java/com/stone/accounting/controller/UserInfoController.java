package com.stone.accounting.controller;

import com.stone.accounting.converter.c2s.UserInfoC2SConverter;
import com.stone.accounting.manager.UserInfoManager;
import com.stone.accounting.model.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stone
 * @date 2022/11/14-@23:08
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {
    @Autowired
    private UserInfoManager userInfoManager;
    @Autowired
    private UserInfoC2SConverter userInfoC2SConverter;

    @RequestMapping("/serach/{id}")
    public UserInfo getUserInfo(@PathVariable("id") Long id) {
        com.stone.accounting.model.common.UserInfo userInfo = userInfoManager.getUserById(id);
        return userInfoC2SConverter.convert(userInfo);
    }
}
