<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mulcam.bean.Account" %>    
<% 
	//request로부터 계좌번호와 출금액 가져오기
	String id = request.getParameter("id");
	int money = Integer.parseInt(request.getParameter("money"));
	//session에서 계좌번호로 계좌 가져오기
	Account acc = (Account)session.getAttribute(id);
	if(acc==null) {
		pageContext.forward("template.jsp?page=accsearch_fail");
	} else { //계좌가 있는지 확인 후 출금 처리하기
		boolean success = acc.withdraw(money);
		//성공 여부에 따라 응답 페이지 forward 하기
		if(success) { //성공시 page=withdraw_success
			pageContext.forward("template.jsp?page=withdraw_success");
		} else { //실패시 page=withdraw_fail
			pageContext.forward("template.jsp?page=withdraw_fail");
		}
	}
%>