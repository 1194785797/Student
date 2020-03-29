package org.Student.dao.impl;

import com.mysql.jdbc.EscapeTokenizer;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Student.dao.IStudentDao;
import org.Student.entity.Student;
import org.Student.util.*;

public class StudentDaoImpl implements IStudentDao {
	Student student = new Student();
	DBUtil dbutil = new DBUtil();
	
	
	//此人是否存在
	public boolean IsExistence(int sno) {
		if (QueryStudentBySno(sno)==null) {
			return false;
		}else {
			return true;
		}
	}
		
	
	
	//根据学号查询
	public Student QueryStudentBySno(int sno) {
		    ResultSet rs = null;
		    
			String sql = "select * from student where sno = ?";
			
			Object[] obj = {sno};
			
			
			rs = dbutil.executeQuery(sql, obj);
			
			try {
				if (rs.next()) {
					int sno1 = rs.getInt("sno");
					String sname = rs.getString("sname");
					int sage = rs.getInt("sage");
					String saddress = rs.getString("saddress");
					String email = rs.getString("email");
					String passwordString = rs.getString("password");
					student = new Student(sno1,sname,sage,saddress,email);
					return student;
	
				}
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(rs!=null)
					rs.close();
					if(dbutil.pstmt!=null)
						dbutil.pstmt.close();
					if(dbutil.connection!=null)
						dbutil.connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	//增加学生
	public boolean AddStudent(Student student) {
		String sql = "insert into student(sno,sname,sage,saddress,email,password)  values(?,?,?,?,?,?)";
		Object[] obj = {
		student.getSno(),
		student.getSname(),
		student.getSage(),
		student.getSaddress(),
		student.getE_mail(),
		student.getPassword()};
		boolean result = dbutil.executeUpdate(sql, obj);
		System.out.println(result);
		return result;
		
	}
	//删除学生
	public boolean DeleteStudentBySno(int sno) {
		String sql = "delete from student where sno = ?";
		
		Object[] obj = {sno};
		boolean result = dbutil.executeUpdate(sql, obj);
		
		return result;
	}
	
	
	//修改学生信息
	
	public boolean UpdateStudentInfoBySno(Student student) {
		
		String sql = "update student set sname=?, sage=?,saddress=?,email=?, password=? where sno=?";
		Object[] obj = {
		student.getSname(),
		student.getSage(),
		student.getSaddress(),
		student.getE_mail(),
		student.getPassword(),
	    student.getSno()
	    };
		boolean result = dbutil.executeUpdate(sql, obj);
//		System.out.println(result);
		return result;
	}
	
	public boolean LoginDao(Student student) {
			String sql = "select * from student where sno=? and password=?";
			Object[] obj = {student.getSno(),student.getPassword()};
			ResultSet rs = dbutil.executeQuery(sql, obj);
			try {
				if (rs.next()) {
					return true;
				}else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally {
				try {
					if(rs!=null)
					rs.close();
					if(dbutil.pstmt!=null)
						dbutil.pstmt.close();
					if(dbutil.connection!=null)
						dbutil.connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
		
	}
	
	public boolean RegisterDao(Student student) {
		
			String sql = "insert into student(sno,sname,sage,saddress,password) values(?,?,?,?,?)";
			Object[] obj = {
			student.getSno(),
			student.getSname(),
			student.getSage(),
			student.getSaddress(),
			student.getPassword()};
			boolean result = dbutil.executeUpdate(sql, obj);
			
			return result;
			
			
	}
	
	public java.util.List<Student> QueryAllStudent() {
		ResultSet rs=null;
		String sql = "select*from student";
		java.util.List<Student> students = new ArrayList<>();
		Object[] obj = null;
		rs = dbutil.executeQuery(sql, obj);
		try {
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				String password = rs.getString("password");
				String email = rs.getString("email");
				student = new Student(no,name,age,address,email, password);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)
				rs.close();
				if(dbutil.pstmt!=null)
					dbutil.pstmt.close();
				if(dbutil.connection!=null)
					dbutil.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}







	
	
}
