package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class MemberUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("MemberUpdate");
        int result = 0;
		LoginDTO dto = new LoginDTO();

		dto.setMem_id(request.getParameter("mem_id"));
		dto.setMem_pw(request.getParameter("mem_pw"));
		dto.setMem_name(request.getParameter("mem_name"));
		dto.setMem_post(request.getParameter("mem_post"));
		dto.setMem_addr(request.getParameter("mem_addr1"));
		dto.setMem_addr2(request.getParameter("mem_addr2"));
		dto.setMem_birth(request.getParameter("mem_birth") + "-" + request.getParameter("mem_month") + "-"
				+ request.getParameter("mem_day"));		
		dto.setMem_tel(request.getParameter("mem_tel1") + "-" + request.getParameter("mem_tel2") + "-"
				+ request.getParameter("mem_tel3"));
		dto.setMem_phone(request.getParameter("mem_phone1") + "-" + request.getParameter("mem_phone2") + "-"
				+ request.getParameter("mem_phone3"));
		dto.setMem_email(request.getParameter("mem_email1") + "@" + request.getParameter("mem_email2"));
		dto.setMem_social(request.getParameter("mem_social"));
		System.out.println(dto.getMem_id());
		System.out.println(dto.getMem_pw());
		System.out.println(dto.getMem_name());
		System.out.println(dto.getMem_birth());
		System.out.println(dto.getMem_tel());
		System.out.println(dto.getMem_phone());
		System.out.println(dto.getMem_post());
		System.out.println(dto.getMem_addr());
		System.out.println(dto.getMem_addr2());
		System.out.println(dto.getMem_email());
		LoginDAO dao = LoginDAO.getInstance();
		result=dao.updateMember(dto);
		System.out.println("성공여부" + result);
		ActionForward forward = new ActionForward();
		forward.setPath("/mypage.do");
		return forward;
	}

}
