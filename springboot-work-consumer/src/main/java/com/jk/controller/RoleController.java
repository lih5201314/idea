package com.jk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.Permission;
import com.jk.model.Role;
import com.jk.service.RoleService;
import com.jk.util.DataGridResult;
import com.jk.util.TreeNoteUtil;

@Controller
@RequestMapping("role")
public class RoleController {

	@Reference
	private RoleService roleService;
	/*@RequestMapping("roleList")
	@ResponseBody
	public  DataGridResult roleList(Integer rows ,Integer page,
			HttpServletResponse response){
		DataGridResult result = new DataGridResult();
		
		PageUtil pageUtil=roleService.roleList(rows,page, response);
		result.setRows(pageUtil.getList());
		result.setTotal(pageUtil.getSumSize());
		return result;
		
		
	}*/
	@RequestMapping("roleList")
	@ResponseBody
	public Map roleList(Integer page, Integer rows){
		HashMap map = new HashMap();
		map.put("start",(page-1)*rows);
		map.put("end",rows);
		Integer count=roleService.queryCount(map);
		List<Role> list=roleService.queryRoleList(map);

		Map  m = new HashMap<>();
		m.put("total",count);
		m.put("rows",list);
		return m;
	}

	
	//getPermissionByRId
	@RequestMapping("getPermissionByRId")
	public  @ResponseBody List<Permission>  getPermissionByRId(Integer id){
	
		List<Permission> list = roleService.getPermissionByRId(id);
		
		list = TreeNoteUtil.getFatherNode(list);
		
		return list;
	}
	//updateRolePermiss
	@RequestMapping("updateRolePermiss")
	public  @ResponseBody String  updateRolePermiss(Integer[] perids,Integer roleId ){
	
		int i = roleService.updateRolePermiss(perids,roleId);
		if(i<0){
			return "0";
		}
		return "1";
	}
	//delRolePermiss
	@RequestMapping("delRolePermiss")
	public  @ResponseBody void  delRolePermiss(String[] ids ){
	
		roleService.delRolePermiss(ids);
		
	
	}
	//add
	@RequestMapping("add")
	public  @ResponseBody void  add(Role role ){
	
		roleService.add(role);
		
	
	}
}
