package com.imooc.test;

import java.util.Date;

import com.imooc.dao.AccountDao;
import com.imooc.model.Account;
import com.imooc.service.TransService;

public class DbcpTest {

	public static void main(String[] args) throws Exception {
		
		//1.通过不同方式操作数据库
		Date a = new Date();
		trans();
		Date b = new Date();
		System.out.println(b.getTime()-a.getTime());
		
		//2.通过DBCP的方法操作数据库
		Date c = new Date();
		transByDbcp();
		Date d = new Date();
		System.out.println(d.getTime()-c.getTime());

	}

	public static void trans() throws Exception {

		AccountDao accountDao = new AccountDao();

		Account from = null;

		from = accountDao.get(1);

		System.out.println(from.toString());
	}
	
	public static void transByDbcp() throws Exception {

		AccountDao accountDao = new AccountDao();

		Account from = null;

		from = accountDao.getByDbcp(1);

		System.out.println(from.toString());
	}
}
