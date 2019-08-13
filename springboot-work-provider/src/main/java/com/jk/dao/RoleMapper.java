package com.jk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jk.model.Permission;
import com.jk.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //@Select("select * from t_role")
	//List<Role> roleList();
    @Select("select permission_id  from role_permission where  role_id = #{id}")
	List<String> getPermissionByRId(Integer id);
    @Select("select * from t_permission") 
	List<Permission> getPermission();
    @Delete("delete  from role_permission where role_id =#{roleId}")
	int updateRolePermiss(Integer roleId);

	void delRolePermiss(String[] ids);
	@Insert("insert into t_role (name,description,text)values(#{name},#{description},#{text})")
	void add(Role role);
    @Select("select count(1) from t_role")
    Integer queryCount(HashMap map);
    @Select("select * from t_role")
    List<Role> queryRoleList(HashMap map);
}