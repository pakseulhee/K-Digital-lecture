<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mulcam.bean.Account" %>    
<%
	String id = request.getParameter("id");
	int money = Integer.parseInt(request.getParameter("money"));
	Account acc = (Account)session.getAttribute(id);
	/* System.out.println(acc); */
	if(acc!=null) {
		acc.deposit(money);
		pageContext.forward("template.jsp?page=deposit_success");
	} else {
		pageContext.forward("template.jsp?page=accsearch_fail");
	}
%>