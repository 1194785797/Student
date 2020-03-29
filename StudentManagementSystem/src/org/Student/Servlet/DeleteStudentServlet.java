package org.Student.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Student.service.IStudentService;
import org.Student.service.impl.StudentServiceImpl;


@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt( request.getParameter("sno"));
//		System.out.println(sno);
		IStudentService iss = new StudentServiceImpl();
		boolean del_result = iss.DeleteStudentBySnoService(sno);
		if (del_result) {
			request.setAttribute("del_result", "1");
		}else {
			request.setAttribute("del_result", "0");
			
		}
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
