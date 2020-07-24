package team.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.dao.CheckDAO;
import team.t.dto.CheckDTO;

public class Stress implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1;
		int limit = 2;
		int op = 2;
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		CheckDAO dao = CheckDAO.getInstance();
		
		listOp.put("op", op);
		listOp.put("startpage", page*10-9);
		List<CheckDTO> stresslist = dao.list(listOp);
		
		int Start = (page - 1) * limit+1;
		int End = page +9;
		if(End > limit) End = limit;
		
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("Start", Start);
		request.setAttribute("End", End);
		request.setAttribute("stresslist", stresslist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/stress.jsp");
		
		return forward;
	}
}