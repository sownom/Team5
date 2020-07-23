package team.t.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.service.Action;
import team.t.service.ActionForward;
import team.t.service.BoardList;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI); 
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 게시판 목록
		if (command.equals("/BoardList.do")) {
			try {
				action = new BoardList();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
		
			}
		// 상세페이지
		}else if(command.equals("/BoardDetail")) {
				try {
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			
		
		}else if(command.equals("/CheckList.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/content/psychological.jsp");
		}else if(command.equals("/Main.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./content/main.jsp");
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {		// redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {							// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}			
		}
		
	} // doProcess() end

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");

		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		doProcess(request, response);
	}

}
