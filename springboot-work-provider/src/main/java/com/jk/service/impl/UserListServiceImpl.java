package com.jk.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.UserListMapper;
import com.jk.dao.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;



import com.jk.model.Role;
import com.jk.model.User;
import com.jk.model.UserRole;
import com.jk.service.UserListService;

@Service
public class UserListServiceImpl implements UserListService {

	@Autowired
	private UserListMapper userListMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;



	@Override
	public List<Role> getUserByRId(Integer id) {
		List <String>list=	userListMapper.getUserByRId(id);
		List<Role> list2=userListMapper.getUser();
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
	public int updateUserPermiss(Integer[] roleIds, Integer uid) {
		// TODO Auto-generated method stub
		int i=userListMapper.updateUserPermiss(uid);
		
		if(i>=0){
			for (int j = 0; j < roleIds.length; j++) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(roleIds[j]);
				userRole.setUserId(uid);
				i=userRoleMapper.insert(userRole);
			}
		}
			return i;
	}

	@Override
	public Integer queryCount(HashMap map) {
		return userListMapper.queryCount(map);
	}

	@Override
	public List<User> queryuserList(HashMap map) {
		return userListMapper.queryuserList(map);
	}

	@Override
	public List<User> queryuserList2() {
		return userListMapper.queryuserList2();
	}

	@Override
	public void addUser(List<User> list) {
		userListMapper.addUser(list);
	}
}
