package com.stone.accounting.model.common;

/**
 * @author stone
 * @date 2022/11/15-@14:40
 */
public class UserInfo {
    private Long id;
    private String username;
    private String salt;
    private String password;

    public UserInfo() {
    }

    public UserInfo(Long id, String username, String salt, String password) {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
