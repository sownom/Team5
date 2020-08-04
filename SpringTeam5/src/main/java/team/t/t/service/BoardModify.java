package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		String page = request.getParameter("page");
		
		BoardDTO board = new BoardDTO();
		board.setBOAR_NO(BOAR_NO);
		board.setBOAR_TITLE(request.getParameter("BOAR_TITLE"));
		board.setBOAR_CONT(request.getParameter("BOAR_CONT"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.boardUpdate(board);
		
		ActionForward forward = new ActionForward();
		return forward;
	}
	
}
