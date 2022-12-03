package com.stone.accounting.dao;

import com.stone.accounting.dao.impl.UserInfoDaoImpl;
import com.stone.accounting.dao.mapper.UserInfoMapper;
import com.stone.accounting.model.persistence.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author stone
 * @date 2022/12/2-@17:19
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserInfoDaoTest {

    @Mock
    private UserInfoMapper userInfoMapper;

    private UserInfoDao userInfoDAO;

    @BeforeEach
    public void setup(){
        userInfoDAO=new UserInfoDaoImpl(userInfoMapper);
    }

    @Test
    public void testGetUserById(){
        //arrage

        Long userId=100L;
        UserInfo userInfo=UserInfo.builder()
                .id(userId)
                .username("hardcore")
                .password("hardcore")
                .createTime(Timestamp.from(Instant.now()))
                .build();
        Mockito.doReturn(userInfo).when(userInfoMapper).getUserById(userId);
        //act
        UserInfo result = userInfoDAO.getUserById(userId);
        //assert

        Assertions.assertEquals(userInfo,result);
        Mockito.verify(userInfoMapper).getUserById(userId);
    }

}
