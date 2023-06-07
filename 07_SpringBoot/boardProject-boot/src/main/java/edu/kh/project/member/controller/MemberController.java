package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
@SessionAttributes({"loginMember"})
public class MemberController {

	@Autowired
	private MemberService service;
	
	/** 로그인 요청 처리(찐)
	 * @return 메인페이지 redirect 주소
	 */
	@PostMapping("/login")
	public String login(Member inputMember, Model model
			, @RequestHeader(value="referer") String referer
			, @RequestParam(value="saveId", required=false) String saveId
			, HttpServletResponse resp
			, RedirectAttributes ra
			) {
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		// 로그인 결과에 따라 리다이렉트 경로를 다르게 지정
		String path = "redirect:"; 
		
		
		if(loginMember != null) { // 로그인 성공 시
			path += "/"; // 메인페이지로 리다이렉트
			
			// 1) model에 로그인한 회원 정보 추가
			model.addAttribute("loginMember", loginMember);
			
			// 쿠키 생성(해당 쿠키에 담을 데이터를 K:V 로 지정)
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) { // 체크 되었을 때
				// 한 달(30일) 동안 유지되는 쿠키 생성
				cookie.setMaxAge(60 * 60 * 24 * 30); // 초 단위로 지정
				
			}else { // 체크 안되었을 때
				// 0초 동안 유지 되는 쿠키 생성
				// -> 기존 쿠기를 삭제
				cookie.setMaxAge(0);
			}
			
			// 클라이언트가 어떤 요청을 할때 쿠키가 첨부될지 경로(주소)를 지정
			cookie.setPath("/"); 
			
			// 만들어진 쿠키를 클라이언트에게 전달
			resp.addCookie(cookie);
			
			// ---------------------------------------------
			
			
		} else { // 로그인 실패 시
			path += referer; // HTTP Header - referer(이전 주소)
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		return path;
	}
	
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session) {
		status.setComplete(); 
		return "redirect:/";
	}
	
	
}







