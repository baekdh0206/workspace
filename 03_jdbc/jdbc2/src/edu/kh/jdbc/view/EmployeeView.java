package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.model.service.EmployeeService;

// 값 입력 / 출력용 클래스
// -> 사용자와 맞닿는(접점) 클래스 == User Interface (UI)
public class EmployeeView {
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n-----------------------------\n");
				System.out.println("----- 사원 관리 프로그램 -----");
				System.out.println("1. 전체 사원 조회"); // 사번, 이름, 부서명, 직급명, 전화번호
														 // 직급코드 오름차순
				
				System.out.println("2. 사번이 일치하는 사원 조회"); 
				// 사번, 이름, 부서명, 직급명, 전화번호 1행 조회
				
				System.out.println("3. 이름에 글자가 포함된 사원 조회"); 
				// 사번, 이름, 부서명, 직급명, 전화번호 N행 조회
				// 사번 오름차순
				
				System.out.println("4. 급여 범위로 조회");
				// 사번, 이름, 직급명, 급여 조회
				// 급여 내림차순
				
				System.out.println("5. 사원 정보 추가");
				// INSERT, SEQUENCE 사용
				
				System.out.println("6. 사번으로 사원 정보 수정");
				// 이메일, 전화전호, 급여 수정

				System.out.println("7. 사번으로 사원 퇴사");
				// ENT_YN, ENT_DATE 수정
				
				System.out.println("8. 사번으로 사원 정보 삭제");
				// DELETE
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1: break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while(input != 0);
		
	}
	
	
}


