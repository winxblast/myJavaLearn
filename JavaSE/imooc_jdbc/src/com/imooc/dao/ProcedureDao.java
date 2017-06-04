package com.imooc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

public class ProcedureDao {

	public static Integer select_count() throws Exception {
		
		Integer count = 0;
		//1.获得连接
		Connection conn = DBUtil.getConnection();
		// 2.获得callablestatement
		CallableStatement cs = conn.prepareCall("CALL sp_select_count(?)");
		cs.registerOutParameter(1, Types.INTEGER);
		//3.执行存储过程
		cs.execute();
		// 4.处理返回的结构：结果集或出参
		count = cs.getInt(1);
		
		return count;
	}
	
	public static List<Goddess> select_filter(String sp_name) throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		
		//1.获得连接
		Connection conn = DBUtil.getConnection();
		// 2.获得callablestatement
		CallableStatement cs = conn.prepareCall("CALL sp_select_filter(?)");
		cs.setString(1, sp_name);
		//3.执行存储过程
		cs.execute();
		//4.处理返回的结构：结果集或出参
		ResultSet rs = cs.getResultSet();
		
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setMobile(rs.getString("mobile"));
			result.add(g);
		}
		
		return result;
	}
	
	public static void select_nofilter() throws SQLException {
		
		//1.获得连接
		Connection conn = DBUtil.getConnection();
		//2.获得callablestatement
		CallableStatement cs = conn.prepareCall("CALL sp_select_nofilter()");
		//3.执行存储过程
		cs.execute();
		//4.处理返回的结构：结果集或出参
		ResultSet rs = cs.getResultSet();
		
		while (rs.next()) {
			System.out.println(rs.getString("user_name")+rs.getString("email")
					+rs.getString("mobile"));
		}
	}
	
}
