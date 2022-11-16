package com.stone.accounting.model.service;

import lombok.*;

/**
 * @author stone
 * @date 2022/11/15-@14:39
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

}
