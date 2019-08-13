package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Permission;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.CheckImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	private UserService userService;



	//验证码
	@RequestMapping("getcode")
	public void getcode(HttpServletRequest request, HttpServletResponse response){
		CheckImgUtil.buildCheckImg(request, response);
	}

	//登陆
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request,User user,String code){
		String lowerCase = request.getSession().getAttribute("checkcode").toString().toLowerCase();
		if(!lowerCase.equals(code.toLowerCase())){
			return "codeError";
		}
     String  str ="0";
User user1=userService.login2(user.getUsername());


        if(user1==null){
            return "user Error";
        }
        if(!user1.getPassword().equals(user.getPassword())){

            return "Password Error";
        }

str="1";
        request.getSession().setAttribute("user", user1);
        return str;

	}

	@RequestMapping("queryPermission")
	@ResponseBody
	public Map roleList(Integer page, Integer rows){
		HashMap map = new HashMap();
		map.put("start",(page-1)*rows);
		map.put("end",rows);
		Integer count=userService.queryCount(map);
		List<Permission> list=userService.queryPermission(map);

		Map  m = new HashMap<>();
		m.put("total",count);
		m.put("rows",list);
		return m;
	}



}
