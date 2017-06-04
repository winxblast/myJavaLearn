package com.imooc;

/**
 * 因为书名找不到或图书序号找不到而造成的异常类
 * @author WXB
 *
 */
public class NoBookException extends Exception {
	public NoBookException () {
		System.out.println("图书不存在！");
	}
}
