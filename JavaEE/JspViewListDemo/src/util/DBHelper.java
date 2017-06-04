package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver"; //数据库驱动
	//连接数据库的URL地址
	private static final String URL = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root"; //数据库的用户名
	private static final String PASSWORD = "939672"; // 数据库的密码
	private static Connection conn = null;
	
	//静态代码块负责加载驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection() {
		if (conn==null) {
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
		Connection conn = DBHelper.getConnection();
		if (conn!=null) {
			System.out.println("数据库连接正常");
		} else {
			System.out.println("数据库连接异常");
		}
	}
}
