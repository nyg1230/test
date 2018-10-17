package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3Servlet
 */
@WebServlet("/test3.do")
public class Test3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3Servlet() {
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
		
		// 2. view에서 전달된 데이터 꺼내오기
		String menu = request.getParameter("menu");
		String taste = null;
		
		System.out.printf("전달된 메뉴 확인 : %s \n", menu);
		
		switch(menu) {
			case "동그랑땡" : taste = "맛있었음"; break;
			case "돈까스덮밥" : taste = "평범했음"; break;
			case "안동찜닭" : taste = "감자가 덜익었음"; break;
			case "롤초밥" : taste = "JMT"; break;
		}
		
		// 응답해야 할 페이지가 동적 페이지인 경우 서블릿을 연결하여 데이터를 가공할 수도 있다.
		RequestDispatcher view = request.getRequestDispatcher("/test3Ack.do");
		
		// 전달하고자 하는 데이터를 추가하여 다음 서블릿에게 전송할 수 있다.
		request.setAttribute("taste", taste);
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
