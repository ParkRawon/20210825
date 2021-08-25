package co.micol.test.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.test.command.LoginCommand;
import co.micol.test.command.LoginFormCommand;
import co.micol.test.command.MainCommand;
import co.micol.test.common.Command;



public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청을 분석하고 처리하는 부분
		request.setCharacterEncoding("utf-8");  //한글깨짐 방지
		String uri = request.getRequestURI();   //요청분석을 위해 uri 구함
		String contextPath = request.getContextPath(); //요청분석을 위해 contextPath룰 구함
		String page = uri.substring(contextPath.length());  //실제요청한 최종 페이지
		String viewPage = null;  //보여줄 페이지(요청의 결과페이지)
		Command command;  //인터페이스 객체 생성
		
		if(page.equals("/main.do")) {       //요청 페이지를 분석하고 실행하는 부분
			command = new MainCommand();
			viewPage = command.execute(request,response);  //실행 후 결과 돌려주기
		} else if(page.equals("/loginForm.do")) {
			command = new LoginFormCommand();
			viewPage = command.execute(request,response);
		} else if(page.equals("/login.do")) {
			command = new LoginCommand();
			viewPage = command.execute(request, response);
		}
		
		if(viewPage != null) {           //view Resolve : 돌려줄 페이지를 지정하는 것
			if(!viewPage.endsWith(".do")) {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp";
				//WEB-INF/views/main/main.jsp
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);  //결과페이지 보여주기
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
