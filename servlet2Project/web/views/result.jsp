<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	// 서블릿에서 전달한 내용 확인하기
	String name = (String)request.getAttribute("name");
	String color = (String)request.getAttribute("color");
	String animal = (String)request.getAttribute("animal");
	String[] foods = (String[])request.getAttribute("food");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>개인 취향 테스트 결과(JSP)</title>
<style>
	span:eq(0) {
		color : blie;
		font-weight : bold;
	}
	span:eq(1) {
		color : green;
	}
	span:eq(2) {
		color : yellow;
	}
</style>
</head>
<body>
	<h1>개인 취향 테스트 결과 확인(JSP)</h1>
	
	<h2 style='color: red;'>개인 취향 테스트 결과</h2>
	<span style='color : blue; font-weight : bold;'><%=name%></span>님의 개인 취향은<br>
	<span style='color:green;'><%=color %><span>색을 좋아하고 <br>
	<span style='color:yellowgreen;'><%=animal %></span>라는 동물을 좋아하시고<br>
	좋아하는 음식은
	<% 
	if(foods!=null) {
		for(String food : foods) {
			out.println(food);
		}
	} else {
		out.print("x ");
	}
	%>
	입니다.
	</body></html>
</body>
</html>