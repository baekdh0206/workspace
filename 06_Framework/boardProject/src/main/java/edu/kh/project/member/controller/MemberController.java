package edu.kh.project.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;


// @RequestMapping: 요청 주소에 맞는 클래스/메서드 연결

// @RequestMapping("요청 주소")
// -> GET / POST 구분 X(모두 받음, 주소만 맞으면 연결)

// @RequestMapping(value="요청 주소", method=RequestMethod.GET/POST)
// -> GET / POST 방식을 구분


@Controller // 요청/응답 클래스 + bean 등록(Spring이 관리하는 객체)
@RequestMapping("/member") // 공통된 주소 앞부분 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리

@SessionAttributes({"loginMember"}) // Model의 이름(key)를 적으면 session으로 추가
public class MemberController {
	
	// 등록된 Bean 중에서 필드와 타입이 일치하는 Bean을 주입
	// -> MemberService를 구현한 MemberServiceImpl의 Bean 주입
	@Autowired
	private MemberService service;
	
	
	// 로그인   : /member/login
	// 로그아웃 : /member/logout
	
	
	// 로그인 (/member/login), POST 방식 처리
	// Class에 작성한 /member를 제외한 나머지 부분을 주소로 작성
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		
		// 파라미터 전달 방법 1 : HttpServletRequest를 이용하는 방법
		// -> Controller 메서드에 매개변수로 HttpServletRequest 작성
		
		// ?매개 변수에 적으면 왜 사용 가능할까??
		// Spring Framework가 제공하는 
		// Argument Resolver(매개 변수 해결사)가 해결해줘서
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		
		// ************** redirect 방법! **************
		// "redirect:요청주소"
		return "redirect:/";
	}
	
	
	
	// @PostMapping
	// -> @RequestMapping의 자식으로
	//    POST 방식 요청을 연결하는 어노테이션
	//@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
						/*@RequestParam("inputPw")*/ String inputPw) {
		
		// 파라미터 전달 방법 2 : @RequestParam 어노테이션 이용(+생략 방법)
		
		// @RequestParam 어노테이션
		
		// - request객체를 이용한 파라미터 전달 어노테이션
		// - 매개변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 주입됨.

		// ** 파라미터의 name 속성 값과
		//    매개 변수명이 같으면 @RequestParam 생략 가능!! **
		
		
		// @RequestParam(value="name", required="fasle", defaultValue="1")
		// [속성]
		// value : 전달 받은 input 태그의 name 속성값
		
		// required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		// -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		// -> required = true인 파라미터가 null인 경우에도 400 Bad Request

		// defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		// -> required = false인 경우 사용
		
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// 메인 페이지 리다이렉트(재요청)
		return "redirect:/"; 
	}
	
	
	//@PostMapping("/login")
	public String login(/*@ModelAttribute*/ Member inputMember ) {
		
		// 파라미터 전달 방법 3 : @ModelAttribute를 이용한 방법
		
		// - DTO(또는 VO)와 같이 사용하는 어노테이션
		
		// - 전달 받은 파라미터의 name 속성 값이
		//   같이 사용되는 DTO의 필드명과 같다면
		//   자동으로 setter를 호출해서 필드에 값을 세팅
		
		// *** @ModelAttribute 사용 시 주의사항 ***
		// - DTO에 기본 생성자가 필수로 존재해야 한다!
		// - DTO에 setter가 필수로 존재해야 한다!
		
		// *** @ModelAttribute 어노테이션은 생략이 가능하다! ***
		
		// *** @ModelAttribute를 이용해 값이 필드에 세팅된 객체를
		//		"커맨드 객체" 라고 한다 ***
		
		
		System.out.println(inputMember);
		
		
		return "redirect:/";
	}
	
	
	// ****************************************************************
	
	// alt + shift + j
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
		
		// Member inputMember : 커맨드 객체(필드에 파라미터 담겨있음)
		
		// @RequestHeader(value="referer") String referer 
		// -> 요청 HTTP header에서 "referer"(이전주소) 값을 얻어와
		//    매개 변수 String referer에 저장
		
		// Model : 데이터 전달용 객체
		// -> 데이터를 K : V 형식으로 담아 전달
		// -> 기본적으로 request scope
		// -> @SessionAttributes 어노테이션과 함께 사용 시 Session scope
		
		// @RequestParam(value="saveId", required=false) String saveId
		// -> name 속성 값이 "saveId"인 파라미터를 전달 받아 저장
		// -> required=false : 필수 아님 (null 허용)
		// (주의) required 속성 미작성 시 기본 값 true
		// -> 파라미터가 전달되지 않는 경우 주의
		
		// HttpServletResponse resp : 서버 -> 클라이언트 응답 방법을 가지고 있는 객체
		
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		// DB 조회 결과 확인
		//System.out.println(loginMember);
		
		// 로그인 결과에 따라 리다이렉트 경로를 다르게 지정
		String path = "redirect:"; 
		
		
		if(loginMember != null) { // 로그인 성공 시
			path += "/"; // 메인페이지로 리다이렉트
			
			// Session에 로그인한 회원 정보 추가
			// Servlet -> HttpSession.setAttribute(key, value);
			// Spring -> Model + @SessionAttributes
			
			// 1) model에 로그인한 회원 정보 추가
			model.addAttribute("loginMember", loginMember);
			// -> 현재는 request scope
			
			// 2) 클래스 위에 @SessionAttributes 추가
			// -> session scope로 변경
			
			
			// ---------------- 아이디 저장 ----------------
			
			/* Cookie란?
			 * - 클라이언트 측(브라우저)에서 관리하는 파일
			 * 
			 * - 쿠키파일에 등록된 주소 요청 시 마다
			 *   자동으로 요청에 첨부되어 서버로 전달됨.
			 * 
			 * - 서버로 전달된 쿠키에
			 *   값 추가, 수정, 삭제 등을 진행한 후 
			 *   다시 클라이언트에게 반환
			 * */
			
			/* Session
			 * - 서버가 클라이언트의 정보를 저장하고 있음 (쿠키와의 차이점)
			 * */
			
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
			cookie.setPath("/"); // localhost/ 이하 모든 주소
								// ex) /  , /member/login,  /member/logout 등
								//     모든 요청에 쿠키 첨부
			
			// 응답 객체(HttpServletResponse)를 이용해서 
			// 만들어진 쿠키를 클라이언트에게 전달
			resp.addCookie(cookie);
			
			
			// ---------------------------------------------
			
			
			
		} else { // 로그인 실패 시
			path += referer; // HTTP Header - referer(이전 주소)
			
			/* redirect(재요청) 시
			 * 기존 요청(request)이 사라지고 
			 * 새로운 요청(request)을 만들게되어
			 * 
			 * redirect된 페이지에서는 이전 요청이 유지 되지 않는다!!!
			 * -> 유지하고 싶으면 어쩔 수 없이 Session을 이용
			 * 
			 * [Spring]
			 * 이런 상황을 해결하기 위한 객체
			 * RedirectAttributes를 제공
			 * 
			 * RedirectAttributes 
			 * - 리다이렉트 시 데이터를 request scope로 전달할 수 있게하는 객체
			 * 
			 * 응답 전 : request scope
			 * 
			 * 응답 중 : session scope로 잠시 이동
			 * 
			 * 응답 후 : request scope 복귀
			 * */
			
			// addFlashAttribute : 잠시 Session에 추가
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			
		}
		
		return path;
	}
	
	 
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session) {
		
		// SessionStatus : 세션 상태를 관리하는 객체
		
		// 세션 무효화
		// Servlet -> HttpSession.invalidate()
		
		// Spring
		// 1) HttpSession을 이용한 경우
		//  -> HttpSession.invalidate()
		
		// 2) Model + @SessionAttributes 이용한 경우
		//  -> SessionStatus.setComplete() 
		
		
		status.setComplete(); 
//		session.invalidate(); // 세션 무효화 
		
		return "redirect:/";
	}
	
	
	
	
	// 로그인 전용 화면 이동
	@GetMapping("/login")
	public String login() {
		
		return "member/login";
	}
	
	
	
	// 회원 가입 페이지 이동
	@GetMapping("/signUp")
	public String signUp() {
		// /WEB-INF/views/member/signUp.jsp  forward(요청 위임)
		// -> ViewResovler가 prefix, suffix를 리턴 값 앞,뒤에 붙임
		return "member/signUp";
	}
	
	
	// 회원 가입 진행
	@PostMapping("/signUp")
	public String signUp(Member inputMember
				, String[] memberAddress
				, RedirectAttributes ra) {
		
		// ----------- 매개 변수 설명 -----------
		// Member inputMember : 커맨드 객체(제출된 파라미터가 저장된 객체)
		
		// String[] memberAddress : 
		// input name="memberAddress" 3개가 저장된 배열
		
		// RedirectAttributes ra : 
		//  리다이렉트 시 데이터를 request scope로 전달하는 객체
		// ----------- ------------ -----------
		
		
		// 12345^^^서울시^^^2층
		// 주소 구분자를 , -> ^^^ 변경
		//String addr = inputMember.getMemberAddress().replaceAll(",", "^^^");
		//inputMember.setMemberAddress(addr);
		// -> 클라이언트가 , 를 직접 입력하면 문제 발생
		
		
		// 만약 주소를 입력하지 않은 경우(,,) null로 변경
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
		
		}else {
			//String.join("구분자", String[])
			// 배열의 요소를 하나의 문자열로 변경
			// 단, 요소 사이에 "구분자" 추가
			String addr = String.join("^^^", memberAddress);
			inputMember.setMemberAddress(addr);
		}
		
		
		// 회원 가입 서비스 호출
		// (DB에 DML 수행 시 성공 행의 개수(int형) 반환)
		int result = service.signUp(inputMember);
		
		// 가입 성공 여부에 따라 주소 결정
		String path = "redirect:";
		String message = null;
		
		if(result > 0) { // 가입 성공
			path += "/"; // 메인 페이지
			
			message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";
			
		} else { // 가입 실패
			// 회원 가입 페이지
//			path += "/member/signUp";  // 절대 경로
			path += "signUp";  // 상대 경로
			
			message = "회원 가입 실패!";
		}
		
		// 리다이렉트 시 session에 잠깐 올라갔다 내려오도록 세팅
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 스프링 예외 처리 방법(3종류, 우선 순위, 중복 사용)
	 * 
	 * 1순위 : 메서드 단위로 처리
	 * 		-> try-catch  / throws
	 * 
	 * 2순위 : 클래스 단위로 처리
	 * 		-> @ExceptionHandler
	 * 
	 * 3순위 : 프로그램 단위(전역) 처리
	 * 		-> @ControllerAdvice
	 * 
	 * */
	
	
	// 현재 클래스에서 발생하는 모든 예외를 모아서 처리
	//@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		
		// Exception e : 예외 정보를 담고있는 객체
		// Model model : 데이터 전달용 객체 (request scope가 기본)
		
		e.printStackTrace(); // 예외 내용/발생 메서드 확인
		
		model.addAttribute("e", e);
		
		// forward 진행 
		// -> Veiw Resolver의 prefix, suffix를 붙여 JSP 경로로 만듦  
		return "common/error";
	}
	
	
	
	
	
	
}
