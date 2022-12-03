package com.stone.accounting.converter;

import com.stone.accounting.converter.p2c.UserInfoP2CConverter;
import com.stone.accounting.model.persistence.UserInfo;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

/**
 * @author stone
 * @date 2022/12/3-@13:47
 */
public class UserInfoP2CConverterTest {
    private UserInfoP2CConverter userInfoP2CConverter=new UserInfoP2CConverter();

    @Test
    public void testDoForward(){

        //arrange
        UserInfo userInfoPersistence = UserInfo.builder()
                .id(1L)
                .username("hardcore")
                .password("hardcore")
                .createTime(Timestamp.from(Instant.now()))
                .build();

        //act
        com.stone.accounting.model.common.UserInfo result = userInfoP2CConverter.convert(userInfoPersistence);
        //assert
        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id",1L)
                .hasFieldOrPropertyWithValue("username","hardcore")
                .hasFieldOrPropertyWithValue("password","hardcore");

    }

    @Test
    public void testDoBackward(){
        //arrange
        com.stone.accounting.model.common.UserInfo userInfoCommon = com.stone.accounting.model.common.UserInfo.builder()
                .id(1L)
                .username("hardcore")
                .password("hardcore")
                .build();

        //act
        UserInfo result = userInfoP2CConverter.reverse().convert(userInfoCommon);
        //assert

        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id",1L)
                .hasFieldOrPropertyWithValue("username","hardcore")
                .hasFieldOrPropertyWithValue("password","hardcore");

    }
}
