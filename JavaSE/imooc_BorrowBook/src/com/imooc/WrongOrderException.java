package com.imooc;

/**
 * 输入其他字符或数字的命令错误的异常类
 * @author WXB
 *
 */
public class WrongOrderException extends Exception {
	public WrongOrderException(){
		System.out.println("命令输入错误！请根据提示输入数字命令！");
	}
}
