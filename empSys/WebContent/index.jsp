<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>欢迎来到员工管理系统</h1>
		
		<c:if test="${sessionScope.emp==null }">
		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
		</c:if>
		
		<c:if test="${sessionScope.emp!=null }">
		<a href="${pageContext.request.contextPath }/EmpListServlet">员工列表</a>
		<a href="${pageContext.request.contextPath }/LogoutServlet">安全退出</a>
		<br>
	          上次登录时间:${lastTime }
		</c:if>
</body>
</html>

