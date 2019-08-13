package com.jk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.model.Role;
import com.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jk.model.LogModel;
import com.jk.model.User;
import com.jk.service.MongdbService;


@Service
public  class MongdbServiceImpl implements MongdbService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public PageUtil queryLog(Integer page, Integer rows,LogModel log) {

		//List<LogModel> list=mongoTemplate.findAll(LogModel.class, "t_loglog");
		Criteria criteria = new Criteria();
		if(log!=null && log.getLogname() != null && log.getLogname().length()>0){
			Pattern pattern = Pattern.compile("^.*"+log.getLogname()+".*$",Pattern.CASE_INSENSITIVE);
			criteria.and("logname").regex(pattern);
		}
		
		if(log!=null && log.getEndDate()!=null && log.getStarDate()!=null){
			criteria.and("logtime").lte(log.getEndDate()).gte(log.getStarDate());
		}
		

		
		Query query = new Query();
		query.addCriteria(criteria);
		
		

		Integer count=(int) mongoTemplate.count(query, LogModel.class,"t_log");
		System.out.println(count);
		
	PageUtil pageUtil = new  PageUtil(count, page, rows);
	Integer skip = pageUtil.getFirstResultCount();
	
	query.skip(skip);
	query.limit(rows);
	
	
	List<LogModel> list=mongoTemplate.find(query,LogModel.class, "t_log");
	pageUtil.setList(list);
	
		return pageUtil;
	}

	public void deleteLog(String logid) {
		// TODO Auto-generated method stub
		String[] split = logid.split(",");
		Criteria criteria = new Criteria();
		criteria.and("_id").in(split);
		Query query = new Query();
		query.addCriteria(criteria);
		mongoTemplate.remove(query,LogModel.class, "t_log");
		
	}

	public void add(LogModel logModel) {
		LogModel logModel2 = new LogModel();
		logModel2.setLogip(logModel.getLogip());
		logModel2.setLogis(logModel.getLogis());
		logModel2.setLogname(logModel.getLogname());
		logModel2.setLogtime(logModel.getLogtime());
		logModel2.setParame(logModel.getParame());
		logModel2.setRequerpath(logModel.getRequerpath());
		logModel2.setReturningValue(logModel.getReturningValue());
		logModel2.setUserId(logModel.getUserId());
		mongoTemplate.save(logModel2);
	}

	public void update(LogModel logModel) {
	 Update update=new Update();
	 update.set("logname",logModel.getLogname());
	 update.set("logip", logModel.getLogip());
	 update.set("logis", logModel.getLogis());
	 update.set("userId", logModel.getUserId());
	 update.set("returningValue",logModel.getReturningValue());
	 update.set("parame", logModel.getParame());
	 update.set("requerpath", logModel.getRequerpath());
	 update.set("logtime", logModel.getLogtime());
	 

		Query query = new 	Query();
		Criteria c = new Criteria();
		c.and("_id").is(logModel.getId());
		query.addCriteria(c);
	
		mongoTemplate.updateFirst(query, update,"t_log");
	}

	public LogModel editList(String id) {
		LogModel logModel2 = mongoTemplate.findById(id, LogModel.class,"t_log");
		return logModel2;
	}




}
