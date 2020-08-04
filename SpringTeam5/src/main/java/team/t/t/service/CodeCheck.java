package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

         System.out.println("CodeCheck");
         
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
	    PrintWriter out = response.getWriter();
		String str = request.getParameter("mycode");
		String sstr = (String) session.getAttribute("str");
          
		System.out.println(str);
	    System.out.println(sstr);
		int result = 0;
		if(str.contentEquals(sstr)) {
			result = 1;
			out.println(result);			
		}else {
			result = 0;
			out.println(result);
			
		}
		
		return null;
	}

}
