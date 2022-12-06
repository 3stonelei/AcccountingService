package com.stone.accounting.controller;

import com.stone.accounting.converter.c2s.UserInfoC2SConverter;
import com.stone.accounting.exception.GlobalExceptionHandler;
import com.stone.accounting.exception.ResourceNotFoundException;
import com.stone.accounting.manager.UserInfoManager;
import com.stone.accounting.model.common.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.security.InvalidParameterException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author stone
 * @date 2022/12/3-@14:10
 */
@ExtendWith(MockitoExtension.class)
public class UserInfoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserInfoManager userInfoManager;
    @Mock
    private UserInfoC2SConverter userInfoC2SConverter;

    @InjectMocks
    private UserInfoController userInfoController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userInfoController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @AfterEach
    public void teardown(){
        reset(userInfoManager);
    }

    @Test
    public void testGetUserInfo() throws Exception {
        //arrange
        UserInfo userInfoCommon = UserInfo.builder()
                .id(1L)
                .username("hardcore")
                .password("hardcore")
                .build();
        com.stone.accounting.model.service.UserInfo userInfoService = com.stone.accounting.model.service.UserInfo.builder()
                .id(1L)
                .username("hardcore")
                .password("hardcore")
                .build();
        doReturn(userInfoCommon).when(userInfoManager).getUserById(1L);
        doReturn(userInfoService).when(userInfoC2SConverter).convert(userInfoCommon);

        //act&&assert
        mockMvc.perform(MockMvcRequestBuilders.get("/v1.0/users/search/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"id\":1,\"username\":\"hardcore\",\"password\":\"hardcore\"}"));


        verify(userInfoManager).getUserById(anyLong());
        verify(userInfoC2SConverter).convert(userInfoCommon);
    }

    @Test
    public void testGetUserInfoByUserIdWithInvalidUserId() throws Exception {
        //arrange
        Long userId=-1L;

        //act
        //assert
        mockMvc.perform(MockMvcRequestBuilders.get("/v1.0/users/search/"+userId))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"errorCode\":\"ID_IS_INVALID\",\"errorType\":\"Client\",\"message\":\"the user id -1 is invalid\",\"statusCode\":406}"));

        verify(userInfoManager,never()).getUserById(userId);
    }


}
