package com.stone.accounting.model.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Common UserInfo Entity.
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
    private String salt;
    private String password;

}
