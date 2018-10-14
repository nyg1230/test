package test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstAckServlet
 */
@WebServlet("/firstAck.srv")
public class FirstAckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstAckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reqSum = (request.getAttribute("requestValue")==null) ? 0 : (Integer)request.getAttribute("requestValue");
		
		// session 영역 확인 값
		// getSession() : 만약 이전에 연결된 내용이 있다면 해당 내용을 가져오지만, 이전에 연결된 내용이 없을 경우 새로 만들어서 가져온다.
		// getSession(false) : 이전 연결정보가 없다면 null을 반환하는 메소드
		HttpSession session = request.getSession(false);
		int sesSum = (session.getAttribute("sessionValue")==null) ? 0 : (Integer)session.getAttribute("sessionValue");
		
		// appication 영역 확인 값
		ServletContext context = this.getServletContext();
		int conSum = (context.getAttribute("contextValue") == null) ? 0 : (int)context.getAttribute("contextValue");
		
		// 결과 확인용 스트림 객체 생성하기
		PrintWriter out = response.getWriter();
		
		String str = "";
		int sum = 30;
		str += "<html><head><title>객체 영역 테스트 결과</title></head>";
		str += "<body>";
		
		// page 영역
		str += "<h3>Page 영역</h3>";
		str += "해당 페이지에만 존재하는 객체의 범위를 말한다.<br>";
		str += "만약 해당 페이지에서 다른 페이지로 이동하면 사라진다.<br>";
		str += "계산 결과  : " + sum; // 오류
		str += "<br><br>";
		
		// request 영역
		str += "<h3>Request 영역</h3>";
		str += "각 페이지 이동 시 연결되어 있는 페이지 간의 데이터를 <br>";
		str += "유지하는 범위를 말한다. 이동하는 각 페이지 간 데이터가 유지되고,<br>";
		str += "서로 다른 연결점을 가지는 페이지를 만났을 때 사라진다.<br>";
		str += "결과 확인 : " + reqSum + "<br><br>";
		
		// session 영역
		str += "<h3>Session 영역</h3>";
		str += "한 번의 웹 브라우저 연결이 지속되는 동안 데이터를 유지하는 범위 말한다.<br>";
		str += "웹 브라우저 연결시 객체가 생성되고 웹브라우저 종료시 객체가 소멸된다.<br>";
		str += "결과 확인 : " + sesSum + "<br><br>";
		
		// application 영역
		str += "<h3>Application(= Context 영역)</h3>";
		str += "서버가 실행되어 있는 동안 객체를 생성하여 유지하는 객체 범위를 말한다.<br>";
		str += "서버가 실행되면 생성되고, 서버가 종료하면 소멸된다.<br>";
		str += "결과 확인 : " + conSum + "<br><br>";
		
		str += "</body></html>";
		
		out.println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
