package com.stone.accounting.model.service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Service userInfo Entity.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressFBWarnings
public class UserInfo {
    private Long id;
    private String username;
    private String password;

}
