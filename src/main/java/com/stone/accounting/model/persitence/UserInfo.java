package com.stone.accounting.model.persitence;

import lombok.*;

import java.sql.Timestamp;

/**
 * @author stone
 * @date 2022/11/15-@14:40
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

    private Long id;
    private String username;
    private String password;
    private String salt;
    private Timestamp createTime;
    private Timestamp updateTime;

}
