package test.sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
//@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 서블릿 생성 시점
    @Override
    public void init() throws ServletException {
    	System.out.println("서블릿 객체가 생성됩니다~!");
    	super.init();
    }
    
    // 서블릿 소멸 시점
    @Override
    public void destroy() {
    	System.out.println("서블릿 객체가 소멸합니다~!");
    	super.destroy();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet() 메소드가 호출됩니다?");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost() 메소드가 호출됩니다.");
		
	}

}
