package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CheckDAO;
import team.t.t.dto.CheckDTO;

public class Game implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int op = 5;
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		CheckDAO dao = CheckDAO.getInstance();
		
		listOp.put("op", op);
		List<CheckDTO> gamelist = dao.list(listOp);
		
		request.setAttribute("gamelist", gamelist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/game.jsp");
		
		return forward;
	}
}