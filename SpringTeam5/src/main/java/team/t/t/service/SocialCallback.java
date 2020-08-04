package team.t.t.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SocialCallback implements Action {

	public String access_token = "";
	public String refresh_token = "";
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
           
		System.out.println("SocialCallback");
		
		String clientId = "COB9GO2ONu4VeTkUjkmY";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "4v19vJfJF7";// 애플리케이션 클라이언트 시크릿값";
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http://localhost/Project01/naverLogin.do", "UTF-8");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		
		System.out.println("apiURL=" + apiURL);
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
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
			if (responseCode == 200) {
				System.out.println(res.toString());
				
				JSONParser parsing = new JSONParser();
				JSONObject jsonobj = (JSONObject) parsing.parse(res.toString());
				
				access_token = (String)jsonobj.get("access_token");
				refresh_token = (String)jsonobj.get("refresh_token");
				
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/content/main.jsp");
		return forward;
	}

}
