package org.Student.service.impl;

import java.util.List;

import org.Student.dao.IStudentDao;
import org.Student.dao.impl.StudentDaoImpl;
import org.Student.entity.Student;
import org.Student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
		IStudentDao isd = new StudentDaoImpl();
	//登录
	public boolean Login(Student student) {
		return isd.LoginDao(student);
				
	}
	//注册
	public boolean Register(Student student) {
		if (!isd.IsExistence(student.getSno())) {
			return isd.RegisterDao(student);
		}else {
			return false;
		}
	}
	//增加
	public boolean AddStudentService(Student student) {
		 if (!isd.IsExistence(student.getSno())) {
			return isd.AddStudent(student);
		}else {
			return false;
		}
	}
	//删除
	public boolean DeleteStudentBySnoService(int sno) {
		if (isd.IsExistence(sno)) {
			return isd.DeleteStudentBySno(sno);
		}else {
			return false;
		}
	
	}
	//修改
	public boolean UpdateStudentService(Student student) {
		if (isd.IsExistence(student.getSno())) {
//			System.out.println(isd.UpdateStudentInfoBySno(student));

			return isd.UpdateStudentInfoBySno(student);
		}else {
			
		return false;
		}
	}
	//根据学号查询
	public Student QueryStudentBySno(int sno) {
		return isd.QueryStudentBySno(sno);
	}
	//查询全部
	public List<Student> QueryAllStudent() {
		return isd.QueryAllStudent();
	}
}
