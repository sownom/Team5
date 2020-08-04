package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardModifyForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		String page = request.getParameter("page");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = dao.getCont(BOAR_NO);
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/boardmodify.jsp");
		return forward;
	}
	
}
