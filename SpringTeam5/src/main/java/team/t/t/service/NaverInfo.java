package team.t.t.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class NaverInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		SocialCallback socialcallback = new SocialCallback();
		HttpSession session = request.getSession();
		forward = socialcallback.execute(request, response);

		System.out.println("NaverInfo");

		if (socialcallback.access_token != null) {
			try {
				String token = socialcallback.access_token; // 네이버 로그인 접근 토큰;
				String header = "Bearer " + token; // Bearer 다음에 공백 추가
				String apiURL = "https://openapi.naver.com/v1/nid/me";
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Authorization", header);
				int responseCode = con.getResponseCode();
				BufferedReader br;
				if (responseCode == 200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				String inputLine;
				StringBuffer res = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				JSONObject jsonObj = (JSONObject) parsing.parse(res.toString());
				JSONObject resObj = (JSONObject) jsonObj.get("response");

				String naverCode = (String) resObj.get("id");
				String email = (String) resObj.get("email");
				String name = (String) resObj.get("name");
				String birthday = (String) resObj.get("birthday");

				System.out.println(naverCode);
				System.out.println(email);
				System.out.println(name);
				System.out.println(birthday);
				int result = 0;
				
				LoginDTO dto = new LoginDTO();
				dto.setMem_id(naverCode);
				dto.setMem_name(name);
				dto.setMem_birth(birthday);
				dto.setMem_email(email);
				String b [] = birthday.split("-");
				String e [] = email.split("@");
				LoginDAO dao = LoginDAO.getInstance();
            
				result = dao.idCheck(naverCode);

				if (result != 1) {
														 	
					request.setAttribute("member", dto);
					request.setAttribute("birth", b);
					request.setAttribute("email", e);
					forward.setPath("memberNform.do");
					return forward;
				
				}else {
					session.setAttribute("id", dto.getMem_id());
					session.setAttribute("name", dto.getMem_name());
					
					forward.setPath("/loginSec.do");
					return forward;
				}				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return forward;
	}
}
