package test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first.srv")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// Page scope (하나의 서블릿 안에 들어있는 변수 영역)
		int sum = num1 + num2;
		
		// Request scope(요청하고 응답하는 페이지 간 데이터를 유지하는 변수 영역)
		request.setAttribute("requestValue", sum);
		
		// Session scope (연결이 유지되는 동안, 즉 사용자가 접속해 있는 동안 유지하는 변수 영역)
		// 사용자 시점의 전역 변수
		HttpSession session = request.getSession();
		session.setAttribute("sessionValue", sum);
		
		// Application scope (서버 자체에 저장되어 모든 사용자가 참조할 수 있는 영역)
		// 서버 시점의 전역 변수
		ServletContext context = this.getServletContext();
		context.setAttribute("contextValue", sum);
		
		RequestDispatcher view = request.getRequestDispatcher("firstAck.srv");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
