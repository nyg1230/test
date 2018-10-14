package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second.srv")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>서블릿 객체 응용</title></head>");
		out.println("<body>");
		
		out.println("<h2> Request 영역 응용 </h2>");
		out.printf("<span style='color:navy; font-weight:bold;'>프로토콜</span> : %s<br>", request.getProtocol());
		out.printf("<span style='color:navy; font-weight:bold;'>서버 명</span> : %s<br>", request.getServerName());
		out.printf("<span style='color:navy; font-weight:bold;'>웹루트 경로</span> : %s<br>", request.getContextPath());
		out.printf("<span style='color:navy; font-weight:bold;'>현재 경로</span> : %s<br>", request.getRequestURI());
		out.printf("<span style='color:navy; font-weight:bold;'>요청자 IP 주소</span> : %s<br><hr>", request.getRemoteAddr());
		
		Enumeration<String> e1 = request.getHeaderNames();
		while(e1.hasMoreElements()) {
			String headerName = e1.nextElement();
			out.printf("<span style='color:navy; font-weight:bold;'>%s</span> : %s<br>", headerName, request.getHeader(headerName));
		}
		
		out.println("<h2> Session 영역 응용 </h2>");
		HttpSession session = request.getSession();
		out.printf("현재 연결된 세션 ID : %s<br>", session.getId());
		out.printf("최근 접속 시간 : %s<br>", new Date(session.getLastAccessedTime()));
		
		out.println("<h2> Context 영역 응용 </h2>");
		ServletContext context = getServletContext();
		
		@SuppressWarnings("unchecked")
		Set<String> ipSet = (HashSet<String>)context.getAttribute("ipSet");
		
		if(ipSet == null) ipSet = new HashSet<String>();
		ipSet.add(request.getRemoteAddr());
		context.setAttribute("ipSet", ipSet);
		
		out.println("<span style='color:navy; font-weight:bold;'>IP 접속자 명단</span> : <br>");
		for(String s : ipSet)
			out.printf("%s<br>", s);
		
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