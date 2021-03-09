package com.mulcam.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mulcam.service.MemberService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pass");
		
		try {
			if(id!=null || password == null) {
				throw new Exception("로그인 실패");
			}
			MemberService svc = new MemberService();
			boolean success = svc.loginMember(id, password);
			if(!success) {
				throw new Exception("로그인 실패");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=makeaccount_form");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=makeaccount_form");
			rd.forward(request, response);
		}
	}
}
