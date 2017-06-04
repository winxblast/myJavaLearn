package com.imooc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.ProcedureDao;
import com.imooc.model.Goddess;

public class ProcedureTest {

	public static void main(String[] args) {
		
//		ProcedureDao.select_nofilter();

		String sp_name = "美";
		List<Goddess> result = null;
		Integer count = null;
		try {
			
			//调用带入参的存储过程
//			result = select_filter(sp_name);
//			showResult(result);
			
			//调用带出参的存储过程
			count = select_count();
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Goddess> select_filter(String sp_name) throws SQLException {
		return ProcedureDao.select_filter(sp_name);
	}
	
	public static Integer select_count() throws Exception {
		return ProcedureDao.select_count();
	}
	
	public static void showResult(List<Goddess> result) {
		for (Goddess goddess : result) {
			System.out.println(goddess.getId()+":"+goddess.getUser_name()+":"
					+goddess.getMobile());
		}
	}
	
}
