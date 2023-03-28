package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

/** 회원 전용 화면
 * @author 백동현(baekdh@iei.or.kr)
 */
public class MemberView {

	private Scanner sc = new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	
	/**
	 * 회원 기능 메뉴
	 */
	public void memberMenu() {
		
		int input = 0;
		
		do {
			try {
				System.out.println("\n===== 회원 기능 =====\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별)");
				System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)"); 
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, UPDATE)");
				
				System.out.println("9. 메인 메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1: selectMyInfo();  break;
				case 2: selectMemberList(); break;
				case 3: updateMember(); break;
				case 4: updatePassword(); break;
				
				case 5: 
					if( unRegisterMember() ) {
						return; // 메인 메뉴
					}
				
				break;
				
				case 9: 
					System.out.println("\n===== 메인 메뉴로 돌아갑니다 =====\n");
					break;
				
				case 0: 
					System.out.println("\n=== 프로그램 종료 ===\n"); 
					
					// JVM 강제 종료 구문
					// 매개변수는 기본 0, 다른 숫자는 오류를 의미
					System.exit(0);
//					Terminates the currently running Java Virtual Machine.
					
				default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");  
				}
				
			}catch (InputMismatchException e) {
				System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
				sc.nextLine(); // 입력버퍼에 잘못된 문자열 제거
				input = -1; // while문 종료 방지
			}
			
		}while(input != 9);
		
	}
	
	
	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {
		System.out.println("\n===== 내 정보 조회 =====\n");
		
		// 회원 번호, 아이디, 이름, 성별(남/여), 가입일
		// Session.loginMember 이용
		
		System.out.println("회원 번호 : " + Session.loginMember.getMemberNo());
		System.out.println("아이디 : " + Session.loginMember.getMemberId());
		System.out.println("이름 : " + Session.loginMember.getMemberName());
		
		if(Session.loginMember.getMemberGender().equals("M")) {
			System.out.println("성별 : 남");
		}else {
			System.out.println("성별 : 여");
		}
		
		System.out.println("가입일 : " + Session.loginMember.getEnrollDate());
		
	}
	
	
	
	/**
	 * 회원 목록 조회
	 */
	private void selectMemberList() {
		System.out.println("\n===== 회원 목록 조회 =====\n");
		
		try {
			// 회원 목록 조회 서비스 호출 후 결과 반환 받기
			List<Member> memberList = service.selectMemberList();
			
			
			if(memberList.isEmpty()) { // 조회 결과 X
				System.out.println("\n===== 조회 결과가 없습니다 =====\n");
				return;
			}
			
			// 1  user04  유저사  남
			// 2  user03  유저삼  여
			// 3  user02  유저이  남
			// 4  user01  유저일  여
			
			for(int i=0 ; i<memberList.size() ; i++) {
				System.out.printf("%d\t\t%s\t\t%s\t\t%s \n",
					i+1,
					memberList.get(i).getMemberId(),
					memberList.get(i).getMemberName(),
					memberList.get(i).getMemberGender());
			}
			
			
		}catch (Exception e) {
			System.out.println("\n***** 회원 목록 조회 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 내 정보 수정
	 */
	private void updateMember() {
		System.out.println("\n===== 내 정보 수정 =====\n");
		// 이름(VARCHAR2) / 성별(CHAR, M/F)
		System.out.print("수정할 이름 : ");
		String memberName = sc.next();
		
		String memberGender = null;
		while(true) {
			System.out.print("수정할 성별(M/F) : ");
			// Java char : 문자 1개
			// DB CHAR : 고정 길이 문자열 (== Java String)
			memberGender = sc.next().toUpperCase();
			
			if(memberGender.equals("M") || memberGender.equals("F")) {
				break;
			}
			
			System.out.println("[M 또는 F를 입력해주세요]");
		}
		
		try {
			int result = service.updateMember(memberName, memberGender, 
										Session.loginMember.getMemberNo());
			// Session.loginMember.getMemberNo() : 로그인한 회원의 번호
			// Service 호출 -> DAO호출 -> UPDATE 수행 -> 결과 행(int)
		
			if(result > 0) { // 성공 
				System.out.println("\n=== 수정 되었습니다 ===\n");
				
				// Service를 호출해서 DB만 수정
				// -> DB와 Java프로그램 데이터 동기화
				Session.loginMember.setMemberName(memberName);
				Session.loginMember.setMemberGender(memberGender);
				
			}else {
				System.out.println("\n*** 수정 실패 ***\n");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 비밀번호 변경
	 */
	private void updatePassword() {
		System.out.println("\n===== 비밀번호 변경 =====\n");
		
		// 현재 비밀번호 입력
		System.out.print("현재 비밀번호 : ");
		String current = sc.next();
		
		String newPw1 = null;
		
		while(true) {
			// 새 비밀번호 입력
			System.out.print("새 비밀번호 : ");
			newPw1 = sc.next();
			
			// 새 비밀번호 확인 입력
			System.out.print("새 비밀번호 확인: ");
			String newPw2 = sc.next();
			
			// 같을 때 까지 무한 반복
			if(newPw1.equals(newPw2)) {
				break;
			}
			
			// 아닐 때
			System.out.println("\n*** 새 비밀번호가 일치하지 않습니다 ***\n");
		}
		
		try {
			// 서비스 호출(현재 비밀번호, 새 비밀번호, 로그인한 회원 번호)
			// -> 성공하면 1 / 실패하면 0 -> int형 변수
			int result = service.updatePassword(current, newPw1, 
											Session.loginMember.getMemberNo());
			
			if(result > 0) { // 1인 경우
				System.out.println("\n=== 비밀번호가 변경되었습니다 ===\n");
				
			}else { // 0인 경우
				System.out.println("\n*** 현재 비밀번호가 일치하지 않습니다 ***\n");
			}
			
		}catch (Exception e) {
			System.out.println("\n***** 비밀번호 변경 중 예외 발생 *****\n");
			e.printStackTrace();
		}
			
	}
	
	
	/**
	 * @return true/false
	 * 회원 탈퇴
	 */
	private boolean unRegisterMember() {
		
		System.out.println("\n===== 회원 탈퇴 =====\n");
		
		System.out.print("현재 비밀번호 : ");
		String memberPw = sc.next();
		
		String code = service.createSecurityCode();
		System.out.printf("보안문자 입력 [%s] :", code);
		String input = sc.next();
		
		// 보안문자 일치여부 확인
		if(!input.equals(code)) { // 일치하지 않으면
			System.out.println("\n*** 보안문자가 일치하지 않습니다 ***\n");
			return false;
		}
		
		while(true) {
			System.out.print("정말 탈퇴 하시겠습니까(Y/N) ?");
			char check = sc.next().toUpperCase().charAt(0);
			
			if(check == 'N') {
				System.out.println("\n=== 탈퇴 취소 === \n");
				return false; // 메서드 종료
			}
			
			if(check == 'Y') {
				break; // 반복문 종료
			}
			
			// 'Y', 'N'이 아닌 경우
			System.out.println("\n*** 잘못 입력 하셨습니다 ***\n");
		}
		
		try {
			// 회원 탈퇴 서비스 호출
			int result = service.unRegisterMember(memberPw, 
												Session.loginMember.getMemberNo());
			
			if(result > 0) {
				System.out.println("\n=== 탈퇴 되었습니다...... ===\n");
				
				// 로그아웃
				Session.loginMember = null;
				
				return true;
				
			}else {
				System.out.println("\n*** 비밀번호가 일치하지 않습니다 ***\n");
			}
			
			
		}catch (Exception e) {
			System.out.println("\n***** 회원 탈퇴 중 예외 발생 *****\n");
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
}
