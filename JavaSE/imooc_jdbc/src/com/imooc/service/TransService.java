package com.imooc.service;

import java.sql.Connection;

import com.imooc.dao.AccountDao;
import com.imooc.dao.TransInfoDao;
import com.imooc.db.DBUtil;
import com.imooc.model.Account;
import com.imooc.model.TransInfo;

public class TransService {

	public String trans(Account from, Account to, Double amount) throws Exception {
		
		AccountDao accountDao = new AccountDao();
		TransInfoDao transInfoDao = new TransInfoDao();
		
		from.setAmount(from.getAmount()-amount);
		accountDao.update(from);
		
		//主动增加报错，看看无事务管理时会出什么错
		String a = null;
		a.split("1");
		
		to.setAmount(to.getAmount()+amount);
		accountDao.update(to);
		
		TransInfo info = new TransInfo();
		info.setSourceId(from.getId());
		info.setSourceAccount(from.getAccount());
		info.setDestinationId(to.getId());
		info.setDestinationAccount(to.getAccount());
		info.setAmount(amount);
		transInfoDao.insert(info);
		
		return "success";
		
	}
	
	/*
	 * 带事务处理的方法
	 */
	public String transaction(Account from, Account to, Double amount) throws Exception {

		Connection conn = DBUtil.getConnection();
		conn.setAutoCommit(false);
		
		try {
			AccountDao accountDao = new AccountDao();
			TransInfoDao transInfoDao = new TransInfoDao();
			
			from.setAmount(from.getAmount() - amount);
			accountDao.update(from);
			
			// 主动增加报错，看看无事务管理时会出什么错
//			String a = null;
//			a.split("1");
			
			to.setAmount(to.getAmount() + amount);
			accountDao.update(to);
			
			TransInfo info = new TransInfo();
			info.setSourceId(from.getId());
			info.setSourceAccount(from.getAccount());
			info.setDestinationId(to.getId());
			info.setDestinationAccount(to.getAccount());
			info.setAmount(amount);
			transInfoDao.insert(info);
			
			conn.commit();
			return "success";
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			return "fail";
		}

	}
	
}
