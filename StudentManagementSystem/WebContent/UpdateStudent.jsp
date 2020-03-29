<%@page import="org.Student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

			<%
			
			Student student = (Student)request.getAttribute("student");
			%>
		<form action="UpdateStudentServlet" method="post">
		
		学号：<input type ="text" name ="sno" readonly="readonly" value="<%=student.getSno() %>"/><br>
		姓名：<input type ="text" name ="sname" value="<%=student.getSname() %>"/><br>
		年龄：<input type ="text" name ="sage" value="<%=student.getSage() %>"/><br>
		地址：<input type ="text" name ="saddress" value="<%=student.getSaddress() %>"/><br>
		邮箱：<input type ="text" name ="email" value="<%=student.getE_mail() %>"/><br>
		密码：<input type ="password" name ="password" value="<%=student.getPassword() %>"/><br>
		<input type = "submit" value = "修改">

		
		
		</form>
</body>
</html>