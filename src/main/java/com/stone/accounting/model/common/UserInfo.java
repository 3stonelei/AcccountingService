package com.stone.accounting.model.common;

import lombok.*;

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
    private String salt;
    private String password;

}
