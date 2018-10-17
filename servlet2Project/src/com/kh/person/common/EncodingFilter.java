package com.kh.person.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter("/*")
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("인코딩 필터 생성!!");
	}
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("인코딩 필터 소멸!");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// doGet()이나 doPost()에 직접 작성하던 문자셋 인코딩을 filter에 등록하여 서블릿에 도착하기 이전에 미리 동작하는 로직을 구현할 수 있다.
		// 이로 인해 서블릿 각각에 들어 있던 인코딩 관련 로직의 중복을 제거할 수 있다.
		
		// 서블릿 수행 전 인코딩 utf-8 변경하기
		System.out.println("------- 인코딩 필터 동작합니다. ------");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		// 서블릿 동작을 수행한 이후에 처리할 로직을 작성한다.
		System.out.println("doFilter() 이후에 처리되는 코드입니다.");
	}

}
