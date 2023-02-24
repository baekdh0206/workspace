package edu.kh.api.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.api.service.APIService;

public class APIView {

	private Scanner sc = new Scanner(System.in);
	private APIService service = new APIService();
	
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			System.out.println("--- API 테스트 프로그램 ---");
			System.out.println("1. equals() + hashCode() ");
			System.out.println("2. String 클래스");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			
			try {
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거
				
				switch(input) {
				case 1 : ex1(); break;
				case 2 : break;
				case 0 : break;
				default : System.out.println("메뉴에 존재하는 번호만 입력 해주세요.");
				}
				
				
			}catch(InputMismatchException e) {
				// Scanner 입력이 잘못된 경우
				System.out.println("잘못된 형식을 입력 하셨습니다. 다시 시도해주세요.");
				sc.nextLine(); // 입력버퍼에 남아있는
							   // 잘못 입력된 문자열을 읽어와 없앰
				
				input = -1; // input값에 0이 아닌 값을 대입하여
							// while이 종료되지 않게함
			}
			
		}while(input != 0);
	}
	
	
	private void ex1() {
		
		// 한 학생의 정보를 입력 받아 Service의 학생 배열에 추가
		// 단, 중복되는 학생은 제외
		System.out.println("\n--- 학생 정보 입력 ---\n");
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classRoom = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼에 남아있는 개행문자 제거
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		if( service.addStudent(grade, classRoom, number, name) ) {
			System.out.println("[추가되었습니다]");
		}else {
			System.out.println("중복되는 학생이 존재하거나 배열이 가득 찼습니다.");
		}
	}
	
	
}
