 package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardList implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 출력할 페이지
		int page = 1;
		int limit = 20;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 검색조건과 검색내용
		String op = request.getParameter("op");
		String sc = request.getParameter("sc");
		
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		listOp.put("op", op);
		listOp.put("sc", sc);
		listOp.put("startpage", page*10-9);
		
		int StartRow = (page - 1) * limit+1;
		int EndRow = page * limit;
		
		BoardDAO dao = BoardDAO.getInstance();
		int listcount = dao.getCount(listOp);
		List<BoardDTO> boardlist = dao.list(listOp);
		
		// 총 페이지수
		int boardPage = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
		
		int StartPage = ((page - 1) / 10) * limit +1;
		int EndPage = StartPage + 10 -1;
		
		if(EndPage > listcount) EndPage = listcount;
		
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("StartPage", StartPage);
		request.setAttribute("EndPage", EndPage);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("listcount", listcount);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/board.jsp");
		
		return forward;
	}

}
