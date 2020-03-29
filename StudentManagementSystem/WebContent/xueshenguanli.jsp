<%@page import="org.Student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="js/vue.js"></script>
    <link rel="stylesheet" href="css/xueshengguanli.css">
    <title>学生管理</title>
</head>

<body>
	
    <div id="max">
        <div id="Navigation">

            <ul v-for="item in items" class="menu_ul">

                <li><img src="icon/menu1.png" alt="" class="menu" @click="isShow(item)"></li>

                <ul v-show="item.issubShow" class="erji">
                    <br>
                    <li v-for="subitem in item.subItems">
                        <h3><img src="icon/shu.png" alt="" width="15" height="15">{{subitem.name}}</h3>
                        <hr>
                    </li>
                </ul>
            </ul>

        </div>
        <div>
        
        
        </div>
        <div id="daohang">
            <li v-for="subitem in items[0].subItems" style="list-style:none;">
               <h3><img src="icon/shu.png" width="15" height="15">{{subitem.name}}</h3>


            </li>

        </div>
        <div id="table">
        <div style =" position: relative;">
      	  </div>
      	  <a style="font-size:40px;margin-left:150px;">学生管理</a>
        <a href="addStudent.jsp" style="margin-left:350px;">新增</a>
            <table >
            	<hr>
                <tr>
                    <td style="width: 150px;">学号</td>
                    <td style="width: 80px; ">姓名</td>
                    <td style="width: 100px; ">年龄</td>
                    <td style="width: 250px;">地址</td>
                    <td style="width: 130px;">操作</td>

                </tr>
                
                <%
                List<Student> students = (List<Student>)request.getAttribute("students");
                for(Student student:students){
               
                %>
                
                <tr>
                	<td><%=student.getSno() %></td>
                	<td><%=student.getSname() %></td>
                	<td><%=student.getSage() %></td>
                	<td><%=student.getSaddress() %></td>
                	<td><a href="QueryStudentInfoBySnoServlet?sno=<%= student.getSno()%>">修改</a>&nbsp
                	<a href="DeleteStudentServlet?sno=<%= student.getSno() %>">删除</a></td>
                
                 
                </tr>
               
                <%
                }
                
                %>
                
                
            </table>

        </div>
    </div>
    <!-- 判断是否修改成功 -->
    <%
     String Update_result =(String) request.getAttribute("result");
    if (Update_result != null ){
    //out.print(result);
    %>
    <script type="text/javascript">
    var s = <%=Update_result %>;
    if(s == '1'){
    	alert("修改成功！");
    }else{
    	alert("修改失败！");
    }
    
    
    
    </script>
    <%
    request.setAttribute("result",null);
    }
    %>
     <!-- 判断是否删除成功 -->
     <%
     String  del_result = (String)request.getAttribute("del_result");
     
     if(del_result!=null){
     
     %>
     <script type = "text/javascript">
     var s =<%=del_result%>
     
     if(s == 1){
    	 alert("删除成功！");
     }else{
    	 alert("删除失败！");
     }
     
     
     </script>
     
     
     <%
         request.setAttribute("del_result",null);
     }
     %>
     <!-- 判断是否增加成功！ -->
     <%
     String  add_result = (String)request.getAttribute("add_result");
     if(add_result != null){
    %>
    <script type ="text/javascript">
    var s= <%= add_result%>;
    if(s == 1){
   	 alert("增加成功！");
    }else{
   	 alert("增加失败！");
    }
    
    
    </script>
    
    <% 	 
    request.setAttribute("add_result",null);

     }
     
     %>
    <script>
        var Navigation = new Vue({
            el: "#max",
            data: {

                items: [{
                    issubShow: false,
                    subItems: [{
                            name: "学生管理"
                        },
                        {
                            name: "学籍管理"
                        },
                        {
                            name: "培养管理"
                        },
                        {
                            name: "考试报名"
                        },
                        {
                            name: "个人信息"
                        }
                    ]
                }]
            },
            methods: {
                isShow: function (item) {
                    item.issubShow === false ? item.issubShow = true : item.issubShow = false;
                    console.log("被点击");
                }
            }
        })
    </script>
</body>

</html>