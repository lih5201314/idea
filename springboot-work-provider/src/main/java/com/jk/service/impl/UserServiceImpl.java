package com.jk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.model.Permission;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


import com.jk.dao.UserMapper;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;


	@Override
	public User login2(String username) {
		return userMapper.login2(username);
	}

	@Override
	public Integer queryCount(HashMap map) {
		return userMapper.queryCount(map);
	}

	@Override
	public List<Permission> queryPermission(HashMap map) {
		return userMapper.queryPermission(map);
	}

}
