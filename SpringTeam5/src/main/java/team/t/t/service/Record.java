package team.t.t.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.RecordDAO;
import team.t.t.dto.RecordDTO;

public class Record implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = null;
		
		id = "guest";
		//id = (String)request.getAttribute(id);

		RecordDAO dao = new RecordDAO();
		List<RecordDTO> dto = dao.list(id);
		
		//페이지 이동 및 데이터 이동
		request.setAttribute("recordlist", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/record.jsp");
		//페이지 이동 및 데이터 이동
		return forward;
	}
}