package team.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.dao.BoardDAO;
import team.t.dto.BoardDTO;

public class BoardDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		String page = request.getParameter("page");

		BoardDAO dao = BoardDAO.getInstance();
		dao.countUpdate(BOAR_NO);
		BoardDTO board = dao.getCont(BOAR_NO);

		// 줄바꿈
		String BOAR_CONT = board.getBOAR_CONT().replace("\n", "<br>");
		request.setAttribute("BOAR_CONT", BOAR_CONT);

		request.setAttribute("board", board);
		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./content/detail.jsp");
		return forward;
	}

}