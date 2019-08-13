package com.jk.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jk.model.Role;
import com.jk.model.User;

public interface UserListService {

	//PageUtil user(Integer rows, Integer page, HttpServletResponse response);

	List<Role> getUserByRId(Integer id);

	int updateUserPermiss(Integer[] roleIds, Integer uid);

    Integer queryCount(HashMap map);

	List<User> queryuserList(HashMap map);

    List<User> queryuserList2();

	void addUser(List<User> list);
}
