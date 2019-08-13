package com.jk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jk.model.Role;
import com.jk.model.User;

public interface UserListMapper {
/*
@Select("select * from t_users")
	List<User> user();
*/

@Select("select role_id  from user_role where  user_id = #{id}")
List<String> getUserByRId(Integer id);
@Select("select * from t_role") 
List<Role> getUser();
@Delete("delete  from user_role where user_id  =#{uid}")
int updateUserPermiss(Integer uid);
    @Select("select count(1) from t_users")
    Integer queryCount(HashMap map);
    @Select("select * from t_users limit #{start},#{end}")
    List<User> queryuserList(HashMap map);
    @Select("select * from t_users ")
    List<User> queryuserList2();

    void addUser(List<User> list);
}
