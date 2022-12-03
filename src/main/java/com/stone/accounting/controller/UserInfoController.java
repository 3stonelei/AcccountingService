package com.stone.accounting.controller;

import com.stone.accounting.converter.c2s.UserInfoC2SConverter;
import com.stone.accounting.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;

/**
 * @author stone
 * @date 2022/11/14-@23:08
 */
@RestController
@RequestMapping("/v1.0/users")
public class UserInfoController {
    private final UserInfoManager userInfoManager;
    private final UserInfoC2SConverter userInfoC2SConverter;

    public UserInfoController(UserInfoManager userInfoManager, UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }

    @RequestMapping("/search/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable("id") Long id) {

        if (id==null||id<=0L){
            throw new InvalidParameterException(String.format("the user id %s is invalid",id));
        }
            com.stone.accounting.model.common.UserInfo userInfo = userInfoManager.getUserById(id);
            return ResponseEntity.ok(userInfoC2SConverter.convert(userInfo));
    }
}
