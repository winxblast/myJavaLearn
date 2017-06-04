package com.imooc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

public class GoddessDao {//Data Access Object数据访问对象设计模式

	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+"INSERT INTO imooc_goddess"
				+"(user_name,sex,age,birthday,email,mobile,create_user,create_date,"
				+"update_user,update_date,isdel)"
				+"VALUES("
				+"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		
		ptmt.execute();
	}
	
	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+"UPDATE imooc_goddess "
				+"SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "
				+"update_user=?,update_date=current_date(),isdel=? "
				+"WHERE id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		
		ptmt.execute();
	}
	
	public void deleteGoddess(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+"DELETE FROM imooc_goddess "
				+"WHERE id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		
		ptmt.execute();
	}
	
	public List<Goddess> query() throws Exception {
		List<Goddess> gs = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT id,user_name,age FROM imooc_goddess");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();		

		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			
			gs.add(g);
		}
		return gs;
	}
	
	public Goddess get(Integer id) throws SQLException {
		Goddess g = null;
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+"SELECT * FROM imooc_goddess "
				+"WHERE id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setSex(rs.getInt("sex"));
			g.setAge(rs.getInt("age"));
			g.setBirthday(rs.getDate("birthday"));//sql.Date是util.Date的子类，所以不需要转换类型
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
	
	public List<Goddess> query(String name, String mobile, String email) throws Exception {
		List<Goddess> result = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM imooc_goddess ");
		sb.append(" WHERE user_name LIKE ? AND mobile LIKE ? AND email LIKE ?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ptmt.setString(2, "%"+mobile+"%");
		ptmt.setString(3, "%"+email+"%");
		
		ResultSet rs = ptmt.executeQuery();	

		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setSex(rs.getInt("sex"));
			g.setAge(rs.getInt("age"));
			g.setBirthday(rs.getDate("birthday"));//sql.Date是util.Date的子类，所以不需要转换类型
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));
			
			result.add(g);
		}
		return result;
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception {
		List<Goddess> result = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM imooc_goddess WHERE 1=1 ");//注意这个1=1，可以使后面的AND放置方便

		if (params!=null && params.size()>0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" AND "+map.get("name")+" "+map.get("relation")+" "+map.get("value")+" ");
			}
		}
		System.out.println(sb.toString());
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();	

		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setSex(rs.getInt("sex"));
			g.setAge(rs.getInt("age"));
			g.setBirthday(rs.getDate("birthday"));//sql.Date是util.Date的子类，所以不需要转换类型
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));
			
			result.add(g);
		}
		return result;
	}
	
}



