<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>删除列表</h2>
	<table border="1" width="800" cellspacing="0">
		<thead>
		   <tr>
		   		<th>id</th>
		   		<th>姓名</th>
		   		<th>密码</th>
		   		<th>性别</th>
		   		<th>年龄</th>
		   		<th>入职日期</th>
		   		<th>薪资</th>
		   		<th>电话</th>
		   		<th>邮箱</th>
		   		<th colspan="2"></th>
		   </tr>
		</thead>
			
		<c:forEach items="${sessionScope.emp}" var="e">
		<tr>
		      <td>${e.id }</td>
		      <td>${e.name }</td>
		      <td>${e.password }</td>
		      <td>${e.gender }</td>
		      <td>${e.age }</td>
		      <td>${e.hiredate }</td>
		      <td>${e.salary }</td>
		      <td>${e.phone }</td>
		      <td>${e.emali }</td>
		      <td><a href="" onclick="qr()">确定删除</a></td>
		      <td><a href="">数据恢复</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
<script type="text/javascript">
	function qr() {
		confirm("确认删除");
	}
</script>