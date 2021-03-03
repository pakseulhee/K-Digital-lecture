<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="per" class="com.mulcam.bean.Person"/>
<jsp:setProperty name="per" property="name" value="hong gil dong"/>
<jsp:setProperty name="per" property="age" value="20"/>
<%-- <%
com.mulcam.bean.Person per = new com.mulcam.bean.Person();
per.setName("hong gil dong");
per.setAge(20);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><jsp:getProperty name="per" property="name"/></h2>
<h2><jsp:getProperty name="per" property="age"/></h2>
<%-- <h2><%=per.getName() %></h2>
<h2><%=per.getAge() %></h2> --%>
</body>
</html>