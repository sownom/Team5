package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class CommInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int COMM_NO = Integer.parseInt(request.getParameter("COMM_NO"));
		String BOAR_NO = request.getParameter("BOAR_NO");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		
		// 댓글입력
		int result = dao.comm_insert(board);
				
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/comment.jsp");
		return forward;
	}

}
