package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imooc.model.File;
import com.imooc.util.DBUtil;

/**
 * 对文件上传的数据库操作
 * @author WXB
 *
 */
public class FileDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void addFile(File file) {
		try {
			conn = DBUtil.getConnection();
			String sql = ""
					+" INSERT INTO file "
					+" (fname, username, fcontent) "
					+" VALUES "
					+" (?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, file.getFname());
			pstmt.setString(2, file.getUsername());
			pstmt.setBytes(3, file.getFcontent());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			DBUtil.closeAll(rs, pstmt, conn);
		}
		
	}
}
