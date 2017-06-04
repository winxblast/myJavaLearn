package com.imooc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.imooc.dao.AccountDao;
import com.imooc.db.C3P0Util;
import com.imooc.model.Account;

public class C3p0Test {

	public static void main(String[] args) throws Exception {
		
		// 1.通过不同方式操作数据库
		Date a = new Date();
		trans();
		Date b = new Date();
		System.out.println(b.getTime() - a.getTime());

		// 2.通过c3p0的方法操作数据库
		Date c = new Date();
		transByC3p0();
		Date d = new Date();
		System.out.println(d.getTime()-c.getTime());

	}
	
	public static void trans() throws Exception {

		AccountDao accountDao = new AccountDao();

		Account from = null;

		from = accountDao.get(1);

		System.out.println(from.toString());
	}
	
	public static void transByC3p0() throws Exception {

		AccountDao accountDao = new AccountDao();

		Account from = null;

		from = accountDao.getByC3p0(1);

		System.out.println(from.toString());
	}

}
