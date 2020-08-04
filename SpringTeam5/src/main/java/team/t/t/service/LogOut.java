package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    
		System.out.println("LogOut");
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Main.do");
		return forward;
	}

}
