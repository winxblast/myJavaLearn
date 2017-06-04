package com.imooc.db;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @ClassName C3P0Util
 * @Description c3p0数据源配置类
 * @author WXB
 * @Date 2017-05-06 19:33
 */
public class C3P0Util {

	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	public static Connection getConnection() {
		
		try {
			return ds.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
