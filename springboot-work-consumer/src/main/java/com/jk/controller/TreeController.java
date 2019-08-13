package com.jk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.Permission;
import com.jk.model.User;
import com.jk.service.TreeService;
import com.jk.util.TreeNoteUtil;

@Controller
@RequestMapping("tree")
public class TreeController {

	@Reference
	private TreeService  treeService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("treeList")
	public @ResponseBody List<Permission>getTreeAll(HttpServletRequest request){
		List<Permission> list=new ArrayList();
		User user = (User) request.getSession().getAttribute("user");
		String key="tree"+user.getId();
		if(redisTemplate.hasKey(key)){
			System.out.println("==========z走缓存=========");
			list=redisTemplate.opsForList().range(key, 0, -1);
			
		}else{
			System.out.println("========数据库==========");
		list=	treeService.treeNode(user.getId());
	list = TreeNoteUtil.getFatherNode(list);
	for (Permission permission : list) {
		
		redisTemplate.opsForList().rightPush(key, permission);
	}
	redisTemplate.expire(key, 30, TimeUnit.MINUTES);
		}
		return list;
	}
}
