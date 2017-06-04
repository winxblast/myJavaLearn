package com.imooc.model;

import java.io.Serializable;

/**
 * 文件的模型类，实体类
 * @author WXB
 *
 */
public class File implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5770069271247109474L;
	private Integer fid;
	private String fname;
	private String username;
	private byte[] fcontent;
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getFcontent() {
		return fcontent;
	}
	public void setFcontent(byte[] fcontent) {
		this.fcontent = fcontent;
	}
	
	
}
