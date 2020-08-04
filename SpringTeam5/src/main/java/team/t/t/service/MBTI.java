package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CheckDAO;
import team.t.t.dto.CheckDTO;

public class MBTI implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int op = 1;
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		CheckDAO dao = CheckDAO.getInstance();
		
		listOp.put("op", op);
		List<CheckDTO> MBTIlist = dao.list(listOp);
		
		request.setAttribute("MBTIlist", MBTIlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/MBTI.jsp");
		
		return forward;
	}
}