package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class MemberLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = -1;
		System.out.println("MemberLogin");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("로그인 아이디 : " + id);
		System.out.println("로그인 비밀번호 : " + pw);

		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto = dao.selectMember(id);
	   
		
		if (!pw.equals(dto.getMem_pw())) {
			request.setAttribute("result", result);
			forward.setPath("/loginForm.do");

		} else {
			session.setAttribute("id", id);
			session.setAttribute("name", dto.getMem_name());
			forward.setPath("/loginSec.do");

		}
		return forward;
	}

}
