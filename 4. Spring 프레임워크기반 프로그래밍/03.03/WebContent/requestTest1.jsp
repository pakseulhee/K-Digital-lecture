<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	 table{
	 	border:1px;
	 	width:500px;
	 }
</style>
<%request.setCharacterEncoding("utf-8"); %>
</head>
<body>
<h1>Request 예제입니다.</h1>
<table>
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>성별</td>
		<td><%=request.getParameter("gender")%></td>
	</tr>	
	<tr>
		<td>취미</td>
		<td><%String[] hobbys = request.getParameterValues("hobby");
			  for(int i=0; i<hobbys.length; i++){
			%>
			<%=hobbys[i]%>&nbsp;&nbsp;
			<%}%>
		</td>
	</tr>	

</table>
</body>
</html>