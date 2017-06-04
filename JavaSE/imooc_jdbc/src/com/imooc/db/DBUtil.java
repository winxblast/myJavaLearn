package com.imooc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
	private static final String USER = "root";
	private static final String PASSWORD = "939672";
	
	private static Connection conn = null;
	
	static {
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的连接
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
	
	/**
	 * 开始测试用，后来就无用了
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		//1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库的连接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//3.通过数据库的连接操作数据库，实现增删改查
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM imooc_goddess");
		
		while (rs.next()) {
			System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
		}
	}
}
