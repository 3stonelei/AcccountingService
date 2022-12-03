package com.stone.accounting.dao.mapper;

import com.stone.accounting.model.persistence.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * interface UserInfoMapper.
 */
@Mapper
public interface UserInfoMapper {

    @Select("select id,username,password,create_time,update_time from t_userinfo where id = #{id}")
    UserInfo getUserById(@Param("id") Long id);

}
