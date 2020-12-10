package com.tky.ibatis.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id ;
    private Long version ;
    private String username ;
    private String password ;
    private Date createTime ;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
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
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
