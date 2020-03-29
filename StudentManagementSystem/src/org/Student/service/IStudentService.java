package org.Student.service;

import org.Student.entity.Student;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public interface IStudentService {
	public boolean Register(Student student);
	
	public boolean Login(Student student);
	
	public boolean AddStudentService(Student student);
	
	public boolean DeleteStudentBySnoService(int sno);
	
	public boolean UpdateStudentService(Student student);
	
	public Student QueryStudentBySno(int sno);
	
	public java.util.List<Student> QueryAllStudent();
	
	
}
