package org.Student.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.entity.Student;
import org.Student.service.IStudentService;
import org.Student.service.impl.StudentServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int sno =Integer.parseInt(request.getParameter("sno"));
		
		String password = request.getParameter("password");
		
		Student student = new Student(sno,password);
		
		IStudentService iss = new StudentServiceImpl();
		boolean result = iss.Login(student);
		if (result == true) {
			System.out.println("111");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			System.out.println(result);
			response.sendRedirect("login.html");
			
		}
//		System.out.println(result);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
