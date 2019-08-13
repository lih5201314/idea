package com.jk.dao;

import java.util.List;

import com.jk.model.User;

public interface UserDao {

	
	public List<User> queryUSerList(String string);

	public void addUser(User user);

	public void deleteUser(String string, List<Integer> list);

	public User queryUpdateUser(User user);

	public void updateUser(User retUser);
}
