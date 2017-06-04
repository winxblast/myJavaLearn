package com.imooc.db;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * @ClassName DBCPUtil
 * @Description DBCP配置类
 * @author WXB
 * @date 2017-05-06 15:21
 */
public class DBCPUtil {
	/**数据源，static*/
	private static DataSource DS;
	
	private static final String configFile = "/dbcp.properties";
	
	/**从数据源获得一个连接*/
	/**
	 * @Title getConnection
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @return Connection 返回类型
	 * @throws
	 */
	public Connection getConnection() {
		Connection conn = null;
		if (DS!=null) {
			try {
				conn = DS.getConnection();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
			
			try {
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		return conn;
	}
	
	/**
	 * 默认的构造方法
	 */
	public DBCPUtil() {
		initDbcp();
	}
	
	
	private static void initDbcp() {
		Properties pops = new Properties();
		
		try {
			pops.load(Object.class.getResourceAsStream(configFile));
			
			DS = BasicDataSourceFactory.createDataSource(pops);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




