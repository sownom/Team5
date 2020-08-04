package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CheckDAO;
import team.t.t.dto.CheckDTO;

public class Stress implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int op = 2;
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		CheckDAO dao = CheckDAO.getInstance();
		
		listOp.put("op", op);
		List<CheckDTO> stresslist = dao.list(listOp);
		
		request.setAttribute("stresslist", stresslist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/stress.jsp");
		
		return forward;
	}
}