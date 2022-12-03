package com.stone.accounting.model.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Persistence UserInfo Entity.
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
