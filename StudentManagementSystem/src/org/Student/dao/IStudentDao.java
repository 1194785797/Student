package org.Student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Student.entity.Student;

public interface IStudentDao {
		
	public boolean IsExistence(int sno) ;
	public Student QueryStudentBySno(int sno) ;
	public boolean AddStudent(Student student) ;
	public boolean DeleteStudentBySno(int sno) ;
	public boolean UpdateStudentInfoBySno(Student student);
	
	public boolean LoginDao(Student student) ;
	public boolean RegisterDao(Student student) ;
	
	public java.util.List<Student> QueryAllStudent() ;


		
}
