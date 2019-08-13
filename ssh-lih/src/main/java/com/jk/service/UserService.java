package com.jk.service;

import java.util.List;

import com.jk.model.User;

public interface UserService {

	
	public List<User> queryUSerList();

	public void addUser(User user);

	public void deleteUser(String ids);

	public User queryUpdateUser(User user);

	public void updateUser(User retUser);
	
}
