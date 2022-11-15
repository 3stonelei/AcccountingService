package com.stone.accounting.model.persitence;

import java.sql.Timestamp;

/**
 * @author stone
 * @date 2022/11/15-@14:40
 */
public class UserInfo {

    private Long id;
    private String username;
    private String password;
    private String salt;
    private Timestamp createTime;
    private Timestamp updateTime;

    public UserInfo() {
    }

    public UserInfo(Long id, String username, String password, String salt, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
