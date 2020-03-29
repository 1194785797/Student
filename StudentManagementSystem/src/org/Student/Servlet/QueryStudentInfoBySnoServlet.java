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


@WebServlet("/QueryStudentInfoBySnoServlet")
public class QueryStudentInfoBySnoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		IStudentService iss = new StudentServiceImpl();
		
		Student student = iss.QueryStudentBySno(sno);
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("UpdateStudent.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
