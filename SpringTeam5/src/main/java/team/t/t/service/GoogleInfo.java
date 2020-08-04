package team.t.t.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GoogleInfo implements Action {

	BufferedReader in  = null;
	InputStream is = null;
	InputStreamReader isr = null;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GoogleInfo");
		
		ActionForward forward = new ActionForward();
		GoogleToken token = new GoogleToken();
		
		forward= token.execute(request, response);
		
		try {
			
			String idToken = token.body.split("=")[1];			
			String apiURL = "https://oauth2.googleapis.com/tokeninfo";
			apiURL += "?id_token="+idToken;
			
			response.setContentType("text/html; charset=utf-8");
		    request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			is = conn.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			in = new BufferedReader(isr);
			

			JSONParser parsing = new JSONParser();
			JSONObject jsonObj = (JSONObject)parsing.parse(in);
			
			String userId = jsonObj.get("sub").toString();
			String name = jsonObj.get("name").toString();
			String email = jsonObj.get("email").toString();
			String imageUrl = jsonObj.get("picture").toString();
			
			System.out.println(userId);
			System.out.println(name);
			System.out.println(email);
			System.out.println(imageUrl);
		
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		
      return forward;
	}

}
