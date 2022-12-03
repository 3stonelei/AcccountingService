package com.stone.accounting.converter;

import com.stone.accounting.converter.c2s.UserInfoC2SConverter;
import com.stone.accounting.model.common.UserInfo;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author stone
 * @date 2022/12/3-@13:47
 */
public class UserInfoC2SConverterTest {
    private UserInfoC2SConverter userInfoC2SConverter=new UserInfoC2SConverter();

    @Test
    public void testDoForward(){

        //arrange
        UserInfo userInfoCommon = UserInfo.builder()
                .id(1L)
                .username("hardcore")
                .password("hardcore")
                .build();

        //act
        com.stone.accounting.model.service.UserInfo result = userInfoC2SConverter.convert(userInfoCommon);
        //assert
        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id",1L)
                .hasFieldOrPropertyWithValue("username","hardcore")
                .hasFieldOrPropertyWithValue("password","hardcore");

    }

    @Test
    public void testDoBackward(){
        //arrange
        com.stone.accounting.model.service.UserInfo userInfoService = com.stone.accounting.model.service.UserInfo.builder()
                .id(1L)
                .username("hardcore")
                .password("hardcore")
                .build();

        //act
        UserInfo result = userInfoC2SConverter.reverse().convert(userInfoService);
        //assert
        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id",1L)
                .hasFieldOrPropertyWithValue("username","hardcore")
                .hasFieldOrPropertyWithValue("password","hardcore");

    }
}
