package com.imooc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 数据库工具类，提供数据库的连接
 */
public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc_uploadfile";
	private static final String USER = "root";
	private static final String PASSWORD = "939672";
	
	private static Connection conn = null;
	
	static{
		try {
			//1.反射，加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
