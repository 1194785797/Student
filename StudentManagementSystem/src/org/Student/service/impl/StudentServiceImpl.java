package org.Student.service.impl;

import java.util.List;

import org.Student.dao.IStudentDao;
import org.Student.dao.impl.StudentDaoImpl;
import org.Student.entity.Student;
import org.Student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
		IStudentDao isd = new StudentDaoImpl();
	//��¼
	public boolean Login(Student student) {
		return isd.LoginDao(student);
				
	}
	//ע��
	public boolean Register(Student student) {
		if (!isd.IsExistence(student.getSno())) {
			return isd.RegisterDao(student);
		}else {
			return false;
		}
	}
	//����
	public boolean AddStudentService(Student student) {
		 if (!isd.IsExistence(student.getSno())) {
			return isd.AddStudent(student);
		}else {
			return false;
		}
	}
	//ɾ��
	public boolean DeleteStudentBySnoService(int sno) {
		if (isd.IsExistence(sno)) {
			return isd.DeleteStudentBySno(sno);
		}else {
			return false;
		}
	
	}
	//�޸�
	public boolean UpdateStudentService(Student student) {
		if (isd.IsExistence(student.getSno())) {
//			System.out.println(isd.UpdateStudentInfoBySno(student));

			return isd.UpdateStudentInfoBySno(student);
		}else {
			
		return false;
		}
	}
	//����ѧ�Ų�ѯ
	public Student QueryStudentBySno(int sno) {
		return isd.QueryStudentBySno(sno);
	}
	//��ѯȫ��
	public List<Student> QueryAllStudent() {
		return isd.QueryAllStudent();
	}
}
