package edu.kh.control.loop.practice;

import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice {

	/* 
	실습 문제 1
	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
	단, 입력한 수는 1보다 크거나 같아야 합니다. 
	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
	
	ex.
	1 이상의 숫자를 입력하세요 : 4			
	1 2 3 4 
	
	1 이상의 숫자를 입력하세요 : 0
	1 이상의 숫자를 입력해주세요.
	*/
	public void practice1() {
	}
	
	/*
	실습문제 2
	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
	단, 입력한 수는 1보다 크거나 같아야 합니다. 

	ex.
	1이상의 숫자를 입력하세요 : 4			
	4 3 2 1						
	
	1이상의 숫자를 입력하세요 : 0
	1 이상의 숫자를 입력해주세요.  
	*/
	public void practice2() {
	}
	
	/*
	실습문제 3
	1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.

	ex.
	정수를 하나 입력하세요 : 8
	1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
	*/
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0; // 합계용 변수
		
		for(int i=1 ; i<=input-1 ; i++) {
			sum += i;
			System.out.print(i + " + ");
		}
		
		sum += input;
		System.out.print(input + " = " + sum);
		
//		for(int i=1 ; i<=input ; i++) {
//			sum += i;
//			
//			if(i == input) { // 마지막 O
//				System.out.print(i + " = " + sum);
//				
//			}else { // 마지막 X
//				System.out.print(i + " + ");
//			}
//		}
		
//		for(int i=1 ; i<=input ; i++) {
//			sum += i;
//			System.out.print(i);
//			
//			// i == input == 마지막
//			if(i != input) { // == 마지막이 아니다
//				System.out.print(" + ");
//			}
//			
//		}
//		
//		System.out.println(" = " + sum);
		
	}
	
	
	
	
	
	/*
	실습문제 4
	사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.

	ex.
	첫 번째 숫자 : 8	첫 번째 숫자 : 4	첫 번째 숫자 : 9
	두 번째 숫자 : 4 	두 번째 숫자 : 8 	두 번째 숫자 : 0
	4 5 6 7 8 			4 5 6 7 8 			1 이상의 숫자를 입력해주세요.
	*/
	public void practice4() {
		
	}
	
	/*
	실습문제 5
	사용자로부터 입력 받은 숫자의 단을 출력하세요.

	ex.
	숫자 : 4
	===== 4단 =====
	4 * 1 = 4
	4 * 2 = 8
	4 * 3 = 12
	4 * 4 = 16
	4 * 5 = 20
	4 * 6 = 24
	4 * 7 = 28
	4 * 8 = 32
	4 * 9 = 36
	 */
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n", dan);
		
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("%d * %d = %d \n", dan, i, dan*i);
		}
	}
	
	
	
	
	/*
	실습문제 6
	사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
	단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.

	숫자 : 4								숫자 : 10
	===== 4단 ===== 						2~9 사이 숫자만 입력해주세요.
	===== 5단 =====
	===== 6단 =====
	===== 7단 =====
	===== 8단 =====
	===== 9단 =====
	(해당 단의 내용들은 길이 상 생략)
	 */
	public void practice6() {
	}
	
	/*
	실습문제 7
	다음과 같은 실행 예제를 구현하세요.

	ex.
	정수 입력 : 4
	*
	**
	***
	****
	*/
	
	public void practice7() {
		
		
	}
	
	
	
	
	/*
	다음과 같은 실행 예제를 구현하세요.
	ex.
	정수 입력 : 4
	****
	***
	**
	*

	*/
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int row=input ; row>=1 ; row--) {
			
			for(int col=row ; col>=1 ; col--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	public void practice9() {}
	public void practice10() {}
	
	
	/*
	다음과 같은 실행 예제를 구현하세요.
	ex.
	정수 입력 : 4
	   *
	  ***
	 *****
	*******
	*/
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		
		for(int row=1 ; row<=input ; row++) {
			
			/* for문 2개 */
			/*
			// 빈칸 먼저 출력
			for(int col=input-row ; col>=1 ; col--) {
				System.out.print(" ");
			}
			
			for(int col=1 ; col<=row * 2 -1 ; col++) {
				System.out.print("*");
			}
			*/
			
			/* for문 1개 , if-else 1개*/
			for(int col=1; col<=input+row-1 ; col++) {
				
				if(input-row >= col) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		
	}
	
	
	
	
	
	/*
	다음과 같은 실행 예제를 구현하세요.
	ex.
	정수 입력 : 5
	*****
	*   *
	*   *
	*   *
	*****
*/
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		
		for(int row=1 ; row<= input ; row++) {
			
			for(int col=1; col<=input ; col++) {
				
				if(row==1 || row==input || col==1 || col==input ) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			
			System.out.println(); // 개행
		}
		
	}
	
	
	
	public void practice13() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

