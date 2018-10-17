package test.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/test1.do")
/*
@WebServlet() 어노테이션을 통해 url 맵핑을 바로 등록할 수도 있다.
단, xml과 어노테이션 둘 모두가 있다면 충돌이 발생하고,
같은 이름을 지닌 서블릿 어노테이션이 있을 경우 역시 충돌이 발생한다.

따라서 개발자 측면에서의 어노테이션 표기법은 무척 간편하지만,
시스템을 운영하는 운영자 측면에서 코드는 web.xml에 등록되어 있는것이 더욱 편리하다 
 */
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 설정
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; setchar=utf-8");
		
		// 2. 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 3. 스트림 객체에 전송할 응답 내용 입력
		out.println("<html><head>");
		out.println("<title>응답 내역확인</title></head>");
		out.println("<body>");
		out.println("<h1>서블릿 등록에 성공하였습니다.</h1>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
