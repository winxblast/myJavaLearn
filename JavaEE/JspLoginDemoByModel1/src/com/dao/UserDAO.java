package com.dao;

import com.po.User;

/*
 * 用户的业务逻辑类
 */
public class UserDAO {

	//用户登录方法
	public boolean userLogin(User u) {
		if ("admin".equals(u.getUsername()) && "admin".equals(u.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
