package com.jk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.Role;
import com.jk.service.UserListService;
import com.jk.util.DataGridResult;

@Controller
@RequestMapping("userList")
public class UserListController {
	@Reference
	private UserListService userListService;
/*	@RequestMapping("user")
	@ResponseBody
	public  DataGridResult user(Integer rows ,Integer page,
			HttpServletResponse response){
		DataGridResult result = new DataGridResult();
		
		PageUtil pageUtil=userListService.user(rows,page, response);
		result.setRows(pageUtil.getList());
		result.setTotal(pageUtil.getSumSize());
		return result;*/
		
		
//	}

	@RequestMapping("userList")
	@ResponseBody
	public Map roleList(Integer page, Integer rows){
		HashMap map = new HashMap();
		map.put("start",(page-1)*rows);
		map.put("end",rows);
		Integer count=userListService.queryCount(map);
		List<User> list=userListService.queryuserList(map);

		Map  m = new HashMap<>();
		m.put("total",count);
		m.put("rows",list);
		return m;
	}



	//getUserByRId
		@RequestMapping("getUserByRId")
		@ResponseBody
		public List<Role> getUserByRId(Integer id){
			List<Role> list=userListService.getUserByRId(id);
			
			return list;
			
		}
		
		//updateUserPermiss
		@RequestMapping("updateUserPermiss")
		@ResponseBody
		public String updateUserPermiss(Integer[] roleIds,Integer uid){
			int i=userListService.updateUserPermiss(roleIds,uid);
			if(i<0){
				return "0";
			}
			return "1";
		}
}
