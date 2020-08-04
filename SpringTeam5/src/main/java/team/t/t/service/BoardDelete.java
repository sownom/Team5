package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;

public class BoardDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		String page = request.getParameter("page");
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.boardDelete(BOAR_NO);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./BoardDetail.do");
		return forward;
	}

}
