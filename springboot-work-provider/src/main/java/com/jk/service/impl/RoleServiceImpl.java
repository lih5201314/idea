package com.jk.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.RoleMapper;
import com.jk.dao.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;



import com.jk.model.Permission;
import com.jk.model.Role;
import com.jk.model.RolePermission;
import com.jk.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	

	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	/*@Override
	public PageUtil roleList(Integer rows, Integer page, HttpServletResponse response) {
		List<Role>list=	roleMapper.roleList();
		
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		PageUtil pageUtil=	new PageUtil((int)pageInfo.getTotal(), page, rows);
		pageUtil.setList(list);
			return pageUtil;
	}*/

	@Override
	public List<Permission> getPermissionByRId(Integer id) {
		List <String> list=roleMapper.getPermissionByRId(id);
		List<Permission> list2=roleMapper.getPermission();
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if(list.get(i).equals(list2.get(j).getId().toString())){
					list2.get(j).setChecked("true");
				}
				
			}
			
		}
		return list2;
		
	}

	@Override
	public int updateRolePermiss(Integer[] perids, Integer roleId) {
		int i=roleMapper.updateRolePermiss(roleId);
		
		if(i>=0){
			for (int j = 0; j < perids.length; j++) {
				 RolePermission rolePermissModel = new RolePermission();
				 rolePermissModel.setPermissionId(perids[j]);
				 rolePermissModel.setRoleId(roleId);
				i=rolePermissionMapper.insert(rolePermissModel);
			}
		}
			return i;
	}

	@Override
	public void delRolePermiss(String[] ids) {
		roleMapper.delRolePermiss(ids);
		
	}

	@Override
	public void add(Role role) {
		roleMapper.add(role);
		
	}

	@Override
	public Integer queryCount(HashMap map) {

		return roleMapper.queryCount(map);
	}

	@Override
	public List<Role> queryRoleList(HashMap map) {
		return roleMapper.queryRoleList(map);
	}
}
