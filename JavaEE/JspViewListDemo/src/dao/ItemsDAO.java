package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

//商品的业务逻辑类
public class ItemsDAO {
	
	//获得所有商品的信息
	public ArrayList<Items> getAllItems() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>(); //商品集合
		
		try {
			conn = DBHelper.getConnection();
			String sql = "SELECT * FROM items;"; //SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				list.add(item); //把一个商品放入集合
			}
			return list; //返回集合
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//根据商品ID获取商品资料
	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "SELECT * FROM items WHERE id=?;"; //SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				return item;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//根据cookie获取最近浏览的5条商品信息
	public ArrayList<Items> getViewList(String list) {
		ArrayList<Items> itemList = new ArrayList<Items>();
		
		if (list!=null && list.length()>0) {
			String[] arr = list.split("&");
			int iCount = 5;
			if (arr.length >= 5) {
				for (int i=arr.length-1; i>=arr.length-iCount; i--) {
					itemList.add(getItemsById(Integer.parseInt(arr[i])));
				}
			} else {
				for (int i=arr.length-1; i>=0; i--) {
					itemList.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemList;
		} else {
			return null;
		}
	}
	
}




