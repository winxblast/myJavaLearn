package com.imooc.action;

import com.imooc.dao.AccountDao;
import com.imooc.model.Account;
import com.imooc.service.TransService;

public class TransAction {

	public static void main(String[] args) {

		try {
			String res = trans();
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String trans() throws Exception {
		
		AccountDao accountDao = new AccountDao();
		TransService transService = new TransService();
		
		Account from = null;
		Account to = null;
		
		from = accountDao.get(1);
		to = accountDao.get(2);
		
		return transService.transaction(from, to, 20d);
	}
}
