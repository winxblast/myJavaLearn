package com.imooc.util;

import java.io.Serializable;

public class CommandTransfer implements Serializable {

	private static final long serialVersionUID = 1382591323314256391L;
	
	private String cmd; // 操作的命令
	private Object data; // 传递的数据
	private boolean flag; // 执行命令是否成功
	private String result; // 返回的结果
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
