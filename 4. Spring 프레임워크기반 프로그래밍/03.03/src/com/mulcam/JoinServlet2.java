package com.mulcam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet2
 */
@WebServlet("/join")
public class JoinServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");//텍스트로 안받아오면 다운로드 해버림
		
		String name = request.getParameter("name"); //네임 속성값 가져오기
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		
		PrintWriter out = response.getWriter(); //프린트하는 객체 만들기
		
		out.write("이름 = "+name+"<br>");
		out.write("주소 = "+addr+"<br>");
		out.write("전화번호 = "+tel+"<br>");
		out.write("취미 = "+hobby+"<br>");
		
		out.close();
	}

}
