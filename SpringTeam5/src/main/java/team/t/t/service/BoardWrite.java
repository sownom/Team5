package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardWrite implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		int result = dao.boardinsert(board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/boardform.jsp");
		return forward;
	}

}
