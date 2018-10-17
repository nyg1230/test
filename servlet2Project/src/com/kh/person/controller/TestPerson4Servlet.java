package com.kh.person.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPerson2Servlet
 */
@WebServlet("/testPerson4.biz")
public class TestPerson4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPerson4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		// 화면 출력용 값 저장하기
		request.setAttribute("name", name);
		request.setAttribute("color", color);
		request.setAttribute("animal", animal);
		request.setAttribute("food", foodArr);
		
		RequestDispatcher view = request.getRequestDispatcher("views/result.jsp");
		
		view.forward(request, response);
		
	}
}
