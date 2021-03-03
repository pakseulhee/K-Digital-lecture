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
		response.setContentType("text/html");//�ؽ�Ʈ�� �ȹ޾ƿ��� �ٿ�ε� �ع���
		
		String name = request.getParameter("name"); //���� �Ӽ��� ��������
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		
		PrintWriter out = response.getWriter(); //����Ʈ�ϴ� ��ü �����
		
		out.write("�̸� = "+name+"<br>");
		out.write("�ּ� = "+addr+"<br>");
		out.write("��ȭ��ȣ = "+tel+"<br>");
		out.write("��� = "+hobby+"<br>");
		
		out.close();
	}

}
