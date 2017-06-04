package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imooc.db.C3P0Util;
import com.imooc.db.DBCPUtil;
import com.imooc.db.DBUtil;
import com.imooc.model.Account;

public class AccountDao {

	public void insert(Account account) throws Exception {
		//1.建立连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+" INSERT INTO account_info "
				+" (account, amount) "
				+" VALUES "
				+" (?,?)";
		//2.获得preparedstatement
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//3.设置值
		ptmt.setString(1, account.getAccount());
		ptmt.setDouble(2, account.getAmount());
		//4.执行
		ptmt.execute();
	}
	
	public void update(Account account) throws Exception {
		//1.建立连接
		Connection conn = DBUtil.getConnection();
		String sql = "" 
				+ " UPDATE account_info "
				+ " SET account=?, amount=? "
				+ " WHERE id=?";
		// 2.获得preparedstatement
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 3.设置值
		ptmt.setString(1, account.getAccount());
		ptmt.setDouble(2, account.getAmount());
		ptmt.setInt(3, account.getId());
		// 4.执行
		ptmt.execute();
	}
	
	public void delete(Account account) throws Exception {
		//1.建立连接
		Connection conn = DBUtil.getConnection();
		String sql = "" 
				+ " DELETE account_info "
				+ " WHERE id=?";
		// 2.获得preparedstatement
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 3.设置值
		ptmt.setInt(1, account.getId());
		// 4.执行
		ptmt.execute();
	}
	
	public List<Account> query(Account account) throws Exception {
		List<Account> result = new ArrayList<Account>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM account_info ");
		sb.append(" WHERE account LIKE ? ");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+account.getAccount()+"%");
		ResultSet rs = ptmt.executeQuery();
		
		Account ac = null;
		while (rs.next()) {
			ac = new Account();
			ac.setId(rs.getInt("id"));
			ac.setAccount(rs.getString("account"));
			ac.setAmount(rs.getDouble("amount"));
			ac.setCreateAt(rs.getDate("create_at"));
			
			result.add(ac);
		}
		return result;
	}

	public Account get(Integer i) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+" SELECT * FROM account_info "
				+" WHERE id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, i);
		ResultSet rs = ptmt.executeQuery();
		
		Account account = new Account();
		while (rs.next()) {
			account.setId(rs.getInt("id"));
			account.setAccount(rs.getString("account"));
			account.setAmount(rs.getDouble("amount"));
			account.setCreateAt(rs.getDate("create_at"));
		}
		
		return account;
	}
	
	public Account getByDbcp(Integer i) throws Exception {
		DBCPUtil dbcp = new DBCPUtil();
		Connection conn = dbcp.getConnection();
		String sql = ""
				+" SELECT * FROM account_info "
				+" WHERE id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, i);
		ResultSet rs = ptmt.executeQuery();
		
		Account account = new Account();
		while (rs.next()) {
			account.setId(rs.getInt("id"));
			account.setAccount(rs.getString("account"));
			account.setAmount(rs.getDouble("amount"));
			account.setCreateAt(rs.getDate("create_at"));
		}
		
		return account;
	}
	
	public Account getByC3p0(Integer i) throws Exception {
		Connection conn = C3P0Util.getConnection();
		String sql = ""
				+" SELECT * FROM account_info "
				+" WHERE id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, i);
		ResultSet rs = ptmt.executeQuery();
		
		Account account = new Account();
		while (rs.next()) {
			account.setId(rs.getInt("id"));
			account.setAccount(rs.getString("account"));
			account.setAmount(rs.getDouble("amount"));
			account.setCreateAt(rs.getDate("create_at"));
		}
		
		return account;
	}
}




