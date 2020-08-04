package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class Update_Be_Info implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Update_Be_Info");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		String id = (String) session.getAttribute("id");
		System.out.println("업데이트 아이디 : " + id);

		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto = dao.selectMember(id);
		String b [] = dto.getMem_birth().split("-");
		String p [] = dto.getMem_phone().split("-");
		String t [] = dto.getMem_tel().split("-");
		
		String e [] = dto.getMem_email().split("@");
					
		request.setAttribute("member", dto);		
		request.setAttribute("phone", p);
		request.setAttribute("tel", t);
		request.setAttribute("birth", b);
		request.setAttribute("email", e);
		
		
		
		forward.setPath("/WEB-INF/views/content/member_update_form.jsp");

		return forward;
	}

}
