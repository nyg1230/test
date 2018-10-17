package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test4AckServlet
 */
@WebServlet("/test4Ack.do")
public class Test4AckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test4AckServlet() {
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
		
		// 2. 웹 페이지에 스트림 연결
		PrintWriter out = response.getWriter();
		
		// 3. 스트림에 내용 출력하기
		out.println("<html>");
		out.println("<head>");
		out.println("<title>에러 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>이 페이지는 에러 페이지 입니다.</h1>");
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
