package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imooc.model.User;
import com.imooc.util.DBUtil;

/**
 * data access object数据访问对象设计模式
 * @author WXB
 *
 */
public class UserDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	/*
	 * 添加用户
	 */
	public void addUser(User u) {
		try {
			conn = DBUtil.getConnection();
			String sql = ""
					+" INSERT INTO user "
					+" (username, password) "
					+" VALUES "
					+" (?, ?) ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			DBUtil.closeAll(rs, pstmt, conn);
		}
	}
	
	public User query(String username) {
		User user = null;
		try {
			conn = DBUtil.getConnection();
			String sql = ""
					+" SELECT * FROM user "
					+" WHERE username=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			
			user = new User();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
//			DBUtil.closeAll(rs, pstmt, conn);
		}
		

	}
	
	public static void main(String[] args) {
		//测试用
		UserDao userDao = new UserDao();
		User user = userDao.query("zhao");
		System.out.println(user.getUsername());
	}
	
}
