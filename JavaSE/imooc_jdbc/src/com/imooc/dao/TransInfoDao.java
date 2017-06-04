package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imooc.db.DBUtil;
import com.imooc.model.Account;
import com.imooc.model.TransInfo;


public class TransInfoDao {

	public void insert(TransInfo transInfo) throws Exception {
		//1.建立连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+" INSERT INTO trans_info "
				+" (source_id, source_account, destination_id, destination_account, amount) "
				+" VALUES "
				+" (?,?,?,?,?)";
		//2.获得preparedstatement
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//3.设置值
		ptmt.setInt(1, transInfo.getSourceId());
		ptmt.setString(2, transInfo.getSourceAccount());
		ptmt.setInt(3, transInfo.getDestinationId());
		ptmt.setString(4, transInfo.getDestinationAccount());
		ptmt.setDouble(5, transInfo.getAmount());
		//4.执行
		ptmt.execute();
	}
	
	public void update(TransInfo transInfo) throws Exception {
		//1.建立连接
		Connection conn = DBUtil.getConnection();
		String sql = "" 
				+ " UPDATE trans_info "
				+ " SET source_id=?, source_account=?, "
				+ " destination_id=?, destination_account=?, amount=? "
				+ " WHERE id=?";
		// 2.获得preparedstatement
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 3.设置值
		ptmt.setInt(1, transInfo.getSourceId());
		ptmt.setString(2, transInfo.getSourceAccount());
		ptmt.setInt(3, transInfo.getDestinationId());
		ptmt.setString(4, transInfo.getDestinationAccount());
		ptmt.setDouble(5, transInfo.getAmount());
		// 4.执行
		ptmt.execute();
	}
	
	public void delete(TransInfo transInfo) throws Exception {
		//1.建立连接
		Connection conn = DBUtil.getConnection();
		String sql = "" 
				+ " DELETE trans_info "
				+ " WHERE id=?";
		// 2.获得preparedstatement
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 3.设置值
		ptmt.setInt(1, transInfo.getId());
		// 4.执行
		ptmt.execute();
	}
	
	public List<TransInfo> query(TransInfo transInfo) throws Exception {
		List<TransInfo> result = new ArrayList<TransInfo>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM trans_info ");
		sb.append(" WHERE account LIKE ? ");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+transInfo.getSourceAccount()+"%");
		ResultSet rs = ptmt.executeQuery();
		
		TransInfo ti = null;
		while (rs.next()) {
			ti = new TransInfo();
			ti.setId(rs.getInt("id"));
			ti.setSourceId(rs.getInt("source_id"));
			ti.setSourceAccount(rs.getString("source_account"));
			ti.setDestinationId(rs.getInt("destination_id"));
			ti.setDestinationAccount(rs.getString("destination_account"));
			ti.setAmount(rs.getDouble("amount"));
			ti.setCreateAt(rs.getDate("create_at"));
			
			result.add(ti);
		}
		return result;
	}
	
}





