package team.t.t.service;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SocialLogin implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   
		System.out.println("SocialLogin");
		    HttpSession session = request.getSession();		
		    String clientId = "COB9GO2ONu4VeTkUjkmY";//애플리케이션 클라이언트 아이디값";
		    String redirectURI = URLEncoder.encode("http://localhost/Project01/naverLogin.do", "UTF-8");
		    SecureRandom random = new SecureRandom();
		    String state = new BigInteger(130, random).toString();
		    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		    apiURL += "&client_id=" + clientId;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&state=" + state;
		    session.setAttribute("state", state);
		     
		    request.setAttribute("apiURL", apiURL);
		    
		    ActionForward forward = new ActionForward();
		    
		    forward.setPath( "/WEB-INF/views/content/loginform.jsp");
		    
		    return  forward;
	}

}
