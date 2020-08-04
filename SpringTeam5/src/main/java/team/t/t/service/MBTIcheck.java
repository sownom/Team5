package team.t.t.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.ResultDAO;
import team.t.t.dto.ResultDTO;

public class MBTIcheck implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int esum = 0;
		int isum = 0;
		int nsum = 0;
		int ssum = 0;
		int tsum = 0;
		int fsum = 0;
		int jsum = 0;
		int psum = 0;
		int eisum = 0;
		int nssum = 0;
		int tfsum = 0;
		int jpsum = 0;
		int op = 1;
		String grade = "";
		String result = "";
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		
		//라디오 버튼 값
		for(int i = 1; i <= 40; i++) {
			grade = String.valueOf(request.getParameter("select" + i));
			
			if(i <= 10) {
				if(grade.substring(1) == "1") {
					esum += Integer.parseInt(request.getParameter("select" + i)) - 1;
					System.out.println("1");
				}else {
					isum += Integer.parseInt(request.getParameter("select" + i)) - 1;
					System.out.println("2");
				}
			}else if((i > 10) && (i <= 20)) {
				if(grade.substring(1) == "1") {
					nsum += Integer.parseInt(request.getParameter("select" + i)) - 1;
				}else {
					ssum += Integer.parseInt(request.getParameter("select" + i)) - 1;
				}
			}else if((i > 20) && (i <= 30)) {
				if(grade.substring(1) == "1") {
					tsum += Integer.parseInt(request.getParameter("select" + i)) - 1;
				}else {
					fsum += Integer.parseInt(request.getParameter("select" + i)) - 1;
				}
			}else {
				if(grade.substring(1) == "1") {
					jsum += Integer.parseInt(request.getParameter("select" + i)) - 1;
				}else {
					psum += Integer.parseInt(request.getParameter("select" + i)) - 1;
				}
			}
		}
		//라디오 버튼 값
		
		//결과값
		if(esum >= isum) {
			result = "E";
			eisum = esum;
		}else if (esum < isum) {
			result = "I";
			eisum = isum;
		}
		
		if(nsum >= ssum) {
			result += "N";
			nssum = nsum;
		}else if (nsum < ssum) {
			result += "S";
			nssum = ssum;
		}
		
		if(tsum >= fsum) {
			result += "T";
			tfsum = tsum;
		}else if (tsum < fsum) {
			result += "F";
			tfsum = fsum;
		}
		
		if(jsum >= psum) {
			result += "J";
			jpsum = jsum;
		}else if (jsum < psum) {
			result += "P";
			jpsum = psum;
		}
		//결과값
		System.out.println(result);
		//정보 검색
		listOp.put("op", op);
		listOp.put("result", result);
		
		ResultDAO dao = ResultDAO.getInstance();
		ResultDTO dto = dao.list(listOp);
		//정보 검색
		
		//페이지 이동 및 데이터 이동
		request.setAttribute("eisum", eisum);
		request.setAttribute("nssum", nssum);
		request.setAttribute("tfsum", tfsum);
		request.setAttribute("jpsum", jpsum);
		request.setAttribute("resultlist", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/content/result.jsp");
		//페이지 이동 및 데이터 이동
		return forward;
	}
}