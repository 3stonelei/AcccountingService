package com.stone.accounting.controller;

import com.stone.accounting.converter.c2s.UserInfoC2SConverter;
import com.stone.accounting.exception.ErrorResponse;
import com.stone.accounting.exception.ResourceNotFoundException;
import com.stone.accounting.exception.ServiceException;
import com.stone.accounting.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getUserInfo(@PathVariable("id") Long id) {
            com.stone.accounting.model.common.UserInfo userInfo = userInfoManager.getUserById(id);
            return ResponseEntity.ok(userInfoC2SConverter.convert(userInfo));
    }
}
