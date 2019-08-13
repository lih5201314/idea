package com.jk.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TreeMapper;
import org.springframework.beans.factory.annotation.Autowired;


import com.jk.dao.TreeMapper;
import com.jk.model.Permission;
import com.jk.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService {
@Autowired
	private TreeMapper treeMapper;

public List<Permission> treeNode(Integer id) {
	// TODO Auto-generated method stub
	return treeMapper.treeNode(id);
}
}
