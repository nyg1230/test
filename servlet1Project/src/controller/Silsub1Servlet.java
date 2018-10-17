package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Silsub1Servlet
 */
@WebServlet("/silsub1.do")
public class Silsub1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Silsub1Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		String userId = request.getParameter("userid");
		String userPw = request.getParameter("pass");
		String userName = request.getParameter("name");
		String userEmail = request.getParameter("email");
		String userPhone = request.getParameter("tel1") + "-"
							+ request.getParameter("tel2") + "-"
							+ request.getParameter("tel3");
		String userJob = request.getParameter("job");
		String userGen = request.getParameter("gender")=="m"?"남성":"여성";
		String[] userHobby = request.getParameterValues("hobby");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>결과 확인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>입력 결과</h1>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td>아이디</td>");
		out.println("<td>"+userId+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>비밀번호</td>");
		out.println("<td>"+userPw+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>이름</td>");
		out.println("<td>"+userName+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>이메일</td>");
		out.println("<td>"+userEmail+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>연락처</td>");
		out.println("<td>"+userPhone+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>직업</td>");
		out.println("<td>"+userJob+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>성별</td>");
		out.println("<td>"+userGen+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>취미</td>");
		out.println("<td>");
		if(userHobby==null) out.println("없음");
		else {
			for(int i=0; i<userHobby.length; i++) {
				if(userHobby[i].equals("reading")) out.print("독서 ");	
				else if(userHobby[i].equals("drama")) out.print("드라마보기 ");
				else if(userHobby[i].equals("soccer")) out.print("축구 ");
				else if(userHobby[i].equals("movie")) out.print("영화보기 ");
				else if(userHobby[i].equals("basket")) out.print("농구 ");
				else if(userHobby[i].equals("game")) out.print("게임 ");
			}
		}
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
