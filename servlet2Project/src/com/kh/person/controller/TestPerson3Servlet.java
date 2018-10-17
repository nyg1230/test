package com.kh.person.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPerson2Servlet
 */
@WebServlet("/testPerson3.biz")
public class TestPerson3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPerson3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 인코딩
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
		
		// 첫번째 매개변수인 HttpServletRequest request는 웹 브라우저로부터 전달된(사용자가 요청한) 데이터를 받아주는 역활
		// 두번째 매개변수인 HttpServletResponse response는 request를 통해 받은 데이터를 가공하여 처리한 결과를 다시 사용자에게 리턴하는 역활
		
		// 2. request로부터 데이터 전달 받기 
		String name = request.getParameter("name");
		String color= request.getParameter("color");
		String animal = request.getParameter("animal");
		
		// 체크박스나 기타 여러 값을 가지는 name을 호출할 경우 name값을 배열 형태로 받아온다.
		String[] foodArr = request.getParameterValues("food");
		
		System.out.printf("name : %s \n", name);
		System.out.printf("color : %s \n", color);
		System.out.printf("animal : %s \n", animal);
		if(foodArr != null) {
			for(String str : foodArr) {
				System.out.printf("foodArr : %s \n", str);
			}
		}
		
		// 2-1. 비즈니스 로직 (service 객체에 들어가는 항목)
		//	웹 서버에서 제공하는 서비스를 처리하기 위한 소스 코드
		//	사용자가 좋아하는 색깔을 기준으로 상품 추천하기
		String recommend = "";
		
		switch(color) {
			case "빨강": recommend = "빨간사과"; break;
			case "갈색": recommend = "사과 나무"; break;
			case "파랑": recommend = "파워에이드"; break;
			case "노랑": recommend = "병아리"; break;
		}
		
		// 3. respone 객체에 처리한 응답 내용 전송하기
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<title>개인취향 테스트 결과</title><head>");
		out.println("<body>");
		out.println("<h2 style='color: red;'>개인 취향 테스트 결과</h2>");
		out.printf("<span style='color : blue; font-weight : bold;'>%s</span>님의 개인 취향은<br>", name);
		out.printf("<span style='color:green;'>%s<span>색을 좋아하고 <br>", color);
		out.printf("<span style='color:yellowgreen;'>%s</span>라는 동물을 좋아하시고<br>", animal);
		out.println("좋아하는 음식은 ");
		if(foodArr!=null) {
			for(String food : foodArr) {
				out.printf("%s ", food);
			}
		} else {
			out.print("x ");
		}
		out.println("입니다.");
		out.printf("<h3>당신에게 추천하는 상품은 %s입니다.</h3>", recommend);
		
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}
}
