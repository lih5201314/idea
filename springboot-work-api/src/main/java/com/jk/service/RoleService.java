package com.jk.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jk.model.Permission;
import com.jk.model.Role;

public interface RoleService {

	//PageUtil roleList(Integer rows, Integer page, HttpServletResponse response);

	List<Permission> getPermissionByRId(Integer id);

	int updateRolePermiss(Integer[] perids, Integer roleId);

	void delRolePermiss(String[] ids);

	void add(Role role);


	Integer queryCount(HashMap map);

	List<Role> queryRoleList(HashMap map);
}
