package com.tky.ibatis.mapper;

import com.tky.ibatis.model.User;

public interface UserMapper {

    public User findByUsername(String username) ; 
}
