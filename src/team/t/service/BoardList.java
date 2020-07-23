package team.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.dao.BoardDAO;
import team.t.dto.BoardDTO;

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
		
		BoardDAO dao = BoardDAO.getInstance();
		//int listcount = dao.getCount(listOp);
		List<BoardDTO> boardlist = dao.list(listOp);
		
		int Start = (page - 1) * limit+1;
		int End = page +9;
		if(End > limit) End = limit;
		
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("Start", Start);
		request.setAttribute("End", End);
		request.setAttribute("boardlist", boardlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/board.jsp");
		
		return forward;
	}

}
