<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>新增学生</title>
    </head>
    <body>
        <form action="AddStudentServlet" method="POST">
            学号：<input type="text" name="sno" /><br>
            姓名：<input type="text" name="sname"/><br>
            年龄：<input type="text" name="sage"/><br>
            地址：<input type="text" name="saddress"/><br>
            邮箱：<input type="text" name="email" /><br>
            密码：<input type="password" name="password" /><br>
            <input type="submit" value="增加" />
        </form>
    </body>
    </html>