package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		
		// Scanner : 프로그램 실행 중 입력을 받는 객체
		
		// 1) class 선언부 위쪽에 
		//    import java.util.Scaaner;   구문 추가
		
		// 2) Scanner 객체 생성
		Scanner sc = new Scanner(System.in); // System.in : 키보드
		
		
		// 3) Scanner를 이용해서 키보드 입력 값 얻어오기
		System.out.print("정수 입력 1 : ");
		
		int input1 = sc.nextInt(); 
		// sc.nextInt() : 다음 입력되는 정수를 얻어옴
		//System.out.println(input1);
		
		System.out.print("정수 입력 2 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d", input1, input2, input1+input2);
		
		
		
	}
}
