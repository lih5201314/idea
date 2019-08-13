package com.jk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.LogModel;
import com.jk.service.MongdbService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;

@Controller
@RequestMapping("mongdb")
public class MongdbController {

	@Reference
	private MongdbService mongdbService;

	@RequestMapping("queryLog")
	public @ResponseBody DataGridResult  queryLog(LogModel log,Integer page, Integer rows){
		DataGridResult result = new DataGridResult();

		PageUtil pageUtil=mongdbService.queryLog(page,rows,log);
		result.setRows(pageUtil.getList());
		result.setTotal(pageUtil.getSumSize());
		return result;

	}
	/*@RequestMapping("queryLog")
	@ResponseBody
	public Map roleList(Integer page, Integer rows){
		HashMap map = new HashMap();
		map.put("start",(page-1)*rows);
		map.put("end",rows);
		Integer count=mongdbService.queryCount(map);
		List<Role> list=mongdbService.queryRoleList(map);

		Map  m = new HashMap<>();
		m.put("total",count);
		m.put("rows",list);
		return m;
	}*/
	
	//deleteLog
	@RequestMapping("deleteLog")
	public @ResponseBody void deleteLog(String logid){
		mongdbService.deleteLog(logid);
	
		
	}
	
	//add
	@RequestMapping("adda")
	public @ResponseBody void add(LogModel logModel){
		
		if(logModel.getId()==null&& logModel.getId().equals(" ")){
			
			mongdbService.add(logModel);
			
		}else{
			
			 mongdbService.update(logModel);
		}
		
	}
	
	//editList
	
	@RequestMapping("editList")
	public @ResponseBody LogModel editList(String id){
		
		
		LogModel logModel=mongdbService.editList(id);
			return logModel;

	}
}
