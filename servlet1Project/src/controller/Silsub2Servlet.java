package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Silsub2Servlet
 */
@WebServlet("/silsub2.do")
public class Silsub2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Silsub2Servlet() {
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
		
		String subName = request.getParameter("userid");
		String subEmail = request.getParameter("useremail");
		String subContent = request.getParameter("content");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>신청곡 확인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>신청자 : " + subName + "</h3>");
		out.println("<h3>이메일 : " + subEmail + "</h3>");
		out.println("<h3>사연<br>" + subContent + "</h3>");
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
