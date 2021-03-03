<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="per" class="com.mulcam.bean.Person"/>
<jsp:setProperty name="per" property="*"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><jsp:getProperty property="name" name="per"/></h3>
<h3><jsp:getProperty property="age" name="per"/></h3>
</body>
</html>