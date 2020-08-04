package team.t.t.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleToken implements Action {

	public String body = "";
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;    
        
        try {
        	
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
            	
            	bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
               
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
              
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        
        body = stringBuilder.toString();
        ActionForward forward = new ActionForward();
    
        forward.setPath("/WEB-INF/views/content/main.jsp");
        
        return forward ;
	}
            
}
