package team.t.t.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.ResultDAO;
import team.t.t.dto.ResultDTO;

public class Stresscheck implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int sum = 0;
		int op = 2;
		String result = "0";
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		//라디오 버튼 값
		for(int i = 1; i <= 30; i++) {
			sum += Integer.parseInt(request.getParameter("select" + i)) - 1;
		}
		//라디오 버튼 값
		
		//결과값
		if(sum <= 15) {
			result = "1";
		}else if((sum >= 16) && (sum <= 25)) {
			result = "2";
		}else if((sum >= 26) && (sum <= 40)) {
			result = "3";
		}else if(sum >= 41) {
			result = "4";
		}
		//결과값
		
		//정보 검색
		listOp.put("op", op);
		listOp.put("result", result);
		
		ResultDAO dao = ResultDAO.getInstance();
		ResultDTO dto = dao.list(listOp);
		//정보 검색
		
		//페이지 이동 및 데이터 이동
		request.setAttribute("sum", sum);
		request.setAttribute("resultlist", dto);
				
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/result.jsp");
		//페이지 이동 및 데이터 이동
		return forward;
	}
}