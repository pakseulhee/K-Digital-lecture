<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <%request.setAttribute("addr", "seoul");
pageContext.forward("pageContextTest2.jsp");%>
 --%>

<!-- 현재 페이지에 대한 요청과 응답을 지정 유알앨로 전부 전송. -->

<jsp:forward page="pageContextTest2.jsp">
	<jsp:param value="seoul" name="addr"/>
</jsp:forward>