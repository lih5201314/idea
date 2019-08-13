package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class TestController {

	
	@RequestMapping("tree")
	public String tree(){
		return "tree";
		
	}
	@RequestMapping("index")
	public String index(){
		return "index";

	}

	@RequestMapping("getcode")
	public String getcode(){
		return "index";

	}
	@RequestMapping("Userlist")
	public String Userlist(){
		return "Userlist";
		
	}
	//rolelist
	@RequestMapping("rolelist")
	public String rolelist(){
		return "rolelist";
		
	}

	//rolelist
	@RequestMapping("musicList")
	public String musicList(){
		return "musicList";

	}

	//menulist
	@RequestMapping("menulist")
	public String menulist(){
		return "menulist";

	}
	@RequestMapping("list")
	public String list(){
		return "list";
		
	}
	//logshow
	@RequestMapping("logshow")
	public String logshow(){
		return "logshow";
		
	}
}
