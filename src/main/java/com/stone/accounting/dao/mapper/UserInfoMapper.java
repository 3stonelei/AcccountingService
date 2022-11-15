package com.stone.accounting.dao.mapper;

import com.stone.accounting.model.persitence.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author stone
 * @date 2022/11/15-@15:19
 */
@Mapper
public interface UserInfoMapper {

    @Select("select id,username,password,create_time,update_time from t_userinfo where id = #{id}")
    UserInfo getUserById(@Param("id") Long id);

}
