<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="pageContextTest3.jsp"></jsp:include>

<%-- 
<%pageContext.include("pageContextTest3.jsp"); %>
 --%>
 
<!-- 위에랑 아래랑 같은 코드다.
 -->
<h2>pageContext의 forward 메소드로 포워딩된 페이지입니다.</h2>
<h2><%=request.getParameter("addr") %></h2>
</body>
</html>