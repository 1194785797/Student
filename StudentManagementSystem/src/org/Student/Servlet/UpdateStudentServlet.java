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


@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int sno = Integer.parseInt (request.getParameter("sno"));
			String sname = request.getParameter("sname");
			int sage = Integer.parseInt (request.getParameter("sage"));
			String saddress = request.getParameter("saddress");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Student student = new Student(sno, sname, sage, saddress, email, password);
			IStudentService iss = new StudentServiceImpl();
			boolean result = iss.UpdateStudentService(student);
			if (result) {
				request.setAttribute("result", "1");
				System.out.println(1);
			}else {
				request.setAttribute("result", "0");
				System.out.println(0);
			}
			
			request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);




	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
