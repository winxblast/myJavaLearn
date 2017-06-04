package com.imooc.model;

import java.io.Serializable;

/**
 * 用户的模型类，实体类
 * @author WXB
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4022940956218641745L;
	private Integer id;
	private String username;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
