package com.jk.service;

import javax.servlet.http.HttpServletRequest;

import com.jk.model.Permission;
import com.jk.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {




	User login2(String username);

    Integer queryCount(HashMap map);

    List<Permission> queryPermission(HashMap map);
}
