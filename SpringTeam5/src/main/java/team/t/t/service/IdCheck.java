package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.LoginDAO;

public class IdCheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("IdCheck");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		System.out.println("id :" + id);
		
		
		LoginDAO dao = LoginDAO.getInstance();
		int result = dao.idCheck(id);
		System.out.println(result);		
		out.println(result);
		return null ;
	}

}
