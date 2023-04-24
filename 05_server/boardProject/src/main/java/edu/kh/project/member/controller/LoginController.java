package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	
	
	// 로그인 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			// 인코딩 처리
			req.setCharacterEncoding("UTF-8");
			
			// 입력된 값(파라미터) 얻어오기
			String inputEmail = req.getParameter("inputEmail");
			String inputPw = req.getParameter("inputPw");
			
			// 서비스 객체 생성
			MemberService service = new MemberService();
			
			// 로그인 서비스 호출 후 결과 반환 받기
			Member loginMember = service.login(inputEmail, inputPw);
			
			System.out.println(loginMember);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
