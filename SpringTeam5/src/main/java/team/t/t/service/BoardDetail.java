package team.t.t.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(true);
		String MEM_ID = (String)session.getAttribute("MEM_ID");
		
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
		
		session.setAttribute("MEM_ID", MEM_ID);
		  
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/detail.jsp");
		return forward;
	}

}
