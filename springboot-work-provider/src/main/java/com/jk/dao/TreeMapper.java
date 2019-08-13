package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jk.model.Permission;

public interface TreeMapper {
	@Select("SELECT  tp.* FROM `t_users` tu , user_role ur ,`t_role` tr , `role_permission` rp ,`t_permission` tp WHERE  ur.user_id=tu.id and ur.role_id=tr.id and rp.role_id=tr.id and rp.permission_id=tp.id AND tu.id= #{value} ")
	List<Permission> treeNode(Integer id);

}
