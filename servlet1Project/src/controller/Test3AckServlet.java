package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3AckServlet
 */
@WebServlet("/test3Ack.do")
public class Test3AckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3AckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 2. 웹 페이지로 표현할 정보를 스트림으로 작성하기
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>맛 평가하기</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>음식 평가하기</h1>");
		out.println("<h1>" + request.getParameter("menu") +  "</h1>");
		out.println("<h3>" + request.getAttribute("taste") + "</h3>");
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
