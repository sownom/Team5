package team.t.t.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class CommList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		
		int comm_page = 1;
		int comm_limit = 10;
		
		if(request.getParameter("comm_page")!= null) {
			comm_page = Integer.parseInt(request.getParameter("comm_page"));
		}
		
		int COMM_NO = Integer.parseInt(request.getParameter("COMM_NO"));
		String BOAR_NO = request.getParameter("BOAR_NO");
		
		int comm_StartRow = (comm_page - 1) * comm_limit + 1;
		int comm_EndRow = comm_page + 9;
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		
		// 댓글 목록
		int comm_listcount = dao.comm_listcount();
		
		// 총 페이지 수
		int comm_Page = comm_listcount / comm_limit + ((comm_listcount % comm_limit == 0) ? 0 : 1);
		
		int comm_StartPage = ((comm_page - 1)/10) * comm_limit +1;
		int comm_EndPage = comm_StartPage + 10 - 1;
		if(comm_EndPage > comm_listcount )
			comm_EndPage = comm_listcount;
		List<BoardDTO> comm_list = dao.comm_list(comm_StartRow,comm_EndRow);
			
		request.setAttribute("comm_page", comm_page);
		request.setAttribute("comm_limit", comm_limit);
		request.setAttribute("comm_StartPage", comm_StartPage);
		request.setAttribute("comm_End", comm_EndPage);
		request.setAttribute("comm_list", comm_list);
		request.setAttribute("comm_listcount", comm_listcount);
		request.setAttribute("board", board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/comment.jsp");
		return forward;
	}

}
