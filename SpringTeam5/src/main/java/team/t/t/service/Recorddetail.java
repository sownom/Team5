package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CheckDAO;
import team.t.t.dao.ResultDAO;
import team.t.t.dto.CheckDTO;
import team.t.t.dto.ResultDTO;

public class Recorddetail implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int op = Integer.parseInt(request.getParameter("no"));
		String result = (String)request.getParameter("grade");
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		listOp.put("op", op);
		listOp.put("result", result);
		
		ResultDAO dao = ResultDAO.getInstance();
		ResultDTO dto = dao.list(listOp);
		
		request.setAttribute("recordlist", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/recorddetail.jsp");
		
		return forward;
	}
}