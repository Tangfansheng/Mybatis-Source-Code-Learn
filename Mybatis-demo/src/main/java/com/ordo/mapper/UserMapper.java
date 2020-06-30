package com.ordo.mapper;

import com.ordo.domain.User;
import com.ordo.mybatis.annotation.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();
}
