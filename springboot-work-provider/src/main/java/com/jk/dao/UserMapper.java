package com.jk.dao;

import com.jk.model.Permission;
import org.apache.ibatis.annotations.Select;

import com.jk.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
@Select("select * from t_users where username=#{username}")
	User login2(String username);
    @Select("select count(1) from t_permission ")
    Integer queryCount(HashMap map);
    @Select("select * from t_permission limit #{start},#{end}")
    List<Permission> queryPermission(HashMap map);
}
