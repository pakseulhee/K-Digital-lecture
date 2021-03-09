package com.mulcam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mulcam.bean.Member;
import com.mulcam.service.MemberService;

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		Member mem = new Member();
		mem.setId(id);
		mem.setPassword(password);
		mem.setName(name);
		mem.setAge(age);
		mem.setSex(sex);
		mem.setEmail(email);
		MemberService svc = new MemberService();
		try {
			svc.joinMember(mem);
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=login");
			rd.forward(request, response);
		}catch(Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=err");
			rd.forward(request, response);
		}
	}
}
