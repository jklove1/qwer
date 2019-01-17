<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function changeImag(){
			// 获取到img的空间对象
			var val = document.getElementById("validate");
			// 每次重新访问地址
			val.src="${pageContext.request.contextPath }/ValidateServlet?date=" + new Date();
		}
	</script>
</head>
<body style="text-align: center">
		<h1>登录界面</h1>
		
		<form action="${pageContext.request.contextPath}/LoginServlet " method="post">
		  姓名:<input type="text" name="name" id="name"><span id="nameSpan"></span>
		  <br>
		  密码:<input type="password" name="password" id="password">
		  <br>
		  验证码:<input type="text" name="validate">
		  <img alt="验证码" id="validate"
		  src="${pageContext.request.contextPath}/ValidateServlet"
		  style="cursor:pointer;" onclick="changeImag()"/>
		  <font color="red">${val_msg }</font>
		  <br>
		   <span style="color: red" >${error_msg }</span>
		   <br>
		  <input type="checkbox" checked="checked">记住用户名
		  <br>
		  <input type="reset" value="重置">
		  <input type="submit" value="登录">
		</form>
		
</body>
</html>