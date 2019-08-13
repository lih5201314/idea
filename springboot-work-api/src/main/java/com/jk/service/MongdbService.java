package com.jk.service;


import com.jk.model.LogModel;
import com.jk.model.Role;
import com.jk.util.PageUtil;

import java.util.HashMap;
import java.util.List;

public interface MongdbService {

	//PageUtil queryLog(LogModel log, Integer page, Integer rows);

	void deleteLog(String logid);

	void add(LogModel logModel);

	void update(LogModel logModel);

	LogModel editList(String id);



	PageUtil queryLog(Integer page, Integer rows, LogModel log);
}
