package team.t.t.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import team.t.t.service.*;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller

public class Control extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/*.do")
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI); 
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 게시판 목록
		if (command.equals("/BoardList.do")) {
			try {
				action = new BoardList();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			// 게시판 글
		}else if(command.equals("/BoardWrite.do")) {
				try {
					action = new BoardWrite();
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
		// 게시판 폼
		}else if(command.equals("/BoardForm.do")) {
			
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/content/boardform.jsp");
		// 상세페이지
		}else if(command.equals("/BoardDetail.do")) {
				try {
					action = new BoardDetail();
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
		// 게시판 수정폼
		}else if(command.equals("/BoardModifyForm.do")) {
			try {
				action = new BoardModifyForm();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 게시판 수정
		}else if(command.equals("/BoardModify.do")) {
			try {
				action = new BoardModify();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 게사판 삭제
		}else if(command.equals("/BoardDelete.do")) {
			try {
				action = new BoardDelete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 댓글
		}else if(command.equals("CommList.do")) {
			try {
				action = new CommList();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		//검사 페이지
		}else if(command.equals("/CheckList.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/content/psychological.jsp");
		// 메인 페이지
		}else if(command.equals("/Main.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/content/main.jsp");
		// 심리검사 페이지
		}else if(command.equals("/MBTI.do")) {
			try {
				action = new MBTI();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Stress.do"))  {
			try {
				action = new Stress();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Depression.do")) {
			try {
				action = new Depression();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Alcohol.do")) {
			try {
				action = new Alcohol();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Game.do")) {
			try {
				action = new Game();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 심리검사 페이지
		// 심리검사 결과 페이지
		}else if(command.equals("/MBTIcheck.do")) {
			try {
				action = new MBTIcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Stresscheck.do")) {
			try {
				action = new Stresscheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Depressioncheck.do")) {
			try {
				action = new Depressioncheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Alcoholcheck.do")) {
			try {
				action = new Alcoholcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Gamecheck.do")) {
			try {
				action = new Gamecheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 심리검사 결과 페이지
		//결과 페이지
		}else if(command.equals("/Record.do")) {
			try {
				action = new Record();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		//결과 상세 페이지
		}else if(command.equals("/Recorddetail.do")) {
			try {
				action = new Recorddetail();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// login 폼
		else if (command.equals("/loginForm.do")) {
			try {
				action = new SocialLogin();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 로그인 처리
		if (command.equals("/login.do")) {
			try {
				
				action = new MemberLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 로그인 폼 이동
		if (command.equals("/loginSec.do")) {

			
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/content/main.jsp");

		}
		// 네이버 로그인 callback
		if (command.equals("/naverLogin.do")) {
			try {
				action = new NaverInfo();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 구글 로그인
		if (command.equals("/googleLogin.do")) {
			try {
				action = new GoogleInfo();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 회원가입 메일인증 코드 발송
		if (command.equals("/mailCode.do")) {
			try {
				action = new MailCode();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 회원가인 메일 인증 코드 체크
		if (command.equals("/codeCheck.do")) {
			try {
				action = new CodeCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 회원 가입 폼
		if (command.equals("/memberform.do"))
			try {

				forward = new ActionForward();
				forward.setPath("/WEB-INF/views/content/memberform.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//네이버 가입 폼
		if (command.equals("/memberNform.do"))
			try {

				forward = new ActionForward();
				forward.setPath("/WEB-INF/views/content/memberNform.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// 회원가입
		if (command.equals("/member.do"))
			try {
				action = new Member();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//  아이디 중복체크
		if (command.equals("/idCheck.do")) {

			try {
				action = new IdCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
       //로그아웃 
		if(command.equals("/logOut.do")) {
			try {
				action = new LogOut();
				forward = action.execute(request, response);
			}catch (Exception e) {
		       e.printStackTrace();
			}
		}
		 //마이 페이지  
		if(command.equals("/mypage.do")) {
			try {
				forward = new ActionForward();
				forward.setPath("/WEB-INF/views/content/mypageform.jsp");
			}catch (Exception e) {
		       e.printStackTrace();
			}
		}
	
		//수정 전 정보 가져와서 수정 폼으로 
		if(command.equals("/member_update_form.do")) {			
 			try {
 				action = new Update_Be_Info();
				forward = action.execute(request, response);
			}catch (Exception e) {
		       e.printStackTrace();
			}
		}
		//수정 폼 
		if(command.equals("/member_update.do")) {			
 			try {
 				action = new MemberUpdate();
				forward = action.execute(request, response);
			}catch (Exception e) {
		       e.printStackTrace();
			}
		}
		//아이디 비밀번호 찾기 폼 
		if(command.equals("/id_pw_find_form.do")) {			
 			try {
 			     forward = new ActionForward();
				forward.setPath("/WEB-INF/views/content/id_pw_find_form.jsp");
			}catch (Exception e) {
		       e.printStackTrace();
			}
		}if(command.equals("/id_pw_find.do")) {			
 			try {
			     forward = new ActionForward();
				forward.setPath("/id_pw_find.jsp");
			}catch (Exception e) {
		       e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {		// redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {							// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}			
		}
		
	} // doProcess() end

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");

		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		doProcess(request, response);
	}

}
