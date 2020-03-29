package org.Student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private String URL = "jdbc:mysql://39.107.109.116:3306/student";
	private String USERNAME = "student";
	private String PASSWORD = "123456";
	public Connection connection=null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	
	
	//通用的增删改
	public boolean  executeUpdate(String sql,Object[] obj) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
			pstmt  = connection.prepareStatement(sql);
			
			for (int i = 0; i < obj.length; i++) {
				
				pstmt.setObject(i+1, obj[i]);
			}
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				return true;
			}
			else {
				return false;
			}
		
		
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (rs!=null)
					rs.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
	
		
		
	}
	
	
	
	//通用的查
	public ResultSet executeQuery(String sql , Object[] obj) {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
			pstmt = connection.prepareStatement(sql);
			if(obj!=null) {
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i+1, obj[i] );
			}
			}
			 rs = pstmt.executeQuery();
		
		return rs;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	
	}
	


}
	
	
	
	

