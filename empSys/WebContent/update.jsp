<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

        <form action="${pageContext.request.contextPath}/UpdateServlet " method="post">
        id:<input type="text" name="id" id="id" placeholder="${emp.id}">
		姓名:<input type="text" name="name" id="name" placeholder="${emp.name}"><span id="namespan"></span>
		密码:<input type="text" name="password" id="password" placeholder="${emp.password}"><span id="passwordspan"></span>
		性别:<input type="text" name="gender" id="gender" placeholder="${emp.gender}"><span id="genderespan"></span><br>
		年龄:<input type="text" name="age" id="age" placeholder="${emp.age}"><span id="agespan" ></span><br>
		入职日期:<input type="date" name="hiredate"  id="hiredate" placeholder="${emp.hiredate}"><span id="datespan"></span><br>
		薪资:<input type="text" name="salary" id="salary" placeholder="${emp.salary}"><span id="salaryspan"></span><br>
		电话:<input type="text" name="phone" id="phone" placeholder="${emp.phone}"><span id="phonespan"></span><br>
		邮箱:<input type="text" name="emali" id="emali" placeholder="${emp.emali}"><span id="emalispan"></span><br>
		确定修改:<input type="submit">
      </form>
</body>
</html>