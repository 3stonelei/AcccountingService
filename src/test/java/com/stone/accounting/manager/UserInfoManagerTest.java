package com.stone.accounting.manager;

import com.stone.accounting.converter.p2c.UserInfoP2CConverter;
import com.stone.accounting.dao.UserInfoDao;
import com.stone.accounting.exception.ResourceNotFoundException;
import com.stone.accounting.model.persistence.UserInfo;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @author stone
 * @date 2022/11/26-@9:43
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserInfoManagerTest {

    private UserInfoManager userInfoManager;

    @Mock
    private UserInfoDao userInfoDAO;

    @BeforeEach
    public void setup(){
        userInfoManager=new UserInfoManagerImpl(userInfoDAO,new UserInfoP2CConverter());
    }

    @Test
    public void testGetUserInfoById(){

        Long userId= 1L;

        UserInfo userInfo=UserInfo.builder()
                .id(userId)
                .username("hardcore")
                .password("hardcore")
                .createTime(Timestamp.from(Instant.now()))
                .build();


        when(userInfoDAO.getUserById(userId)).thenReturn(userInfo);


        val result = userInfoManager.getUserById(userId);


        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id",userId)
                .hasFieldOrPropertyWithValue("username","hardcore")
                .hasFieldOrPropertyWithValue("password","hardcore");


    }

    @Test
    void testGetUserInfoByIdWithInvalidUserId(){
        Long userId = -1L;
        doReturn(null).when(userInfoDAO.getUserById(userId));

        assertThrows(ResourceNotFoundException.class,()->userInfoManager.getUserById(userId));
        verify(userInfoManager).getUserById(userId);
    }
}