package edu.kh.control.loop.practice;

import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice2 {

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
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc .nextInt();
		
		if(input >= 1) {
			for(int i=1 ; i<=input ; i++) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
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
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc .nextInt();
		
		if(input >= 1) {
			for(int i=input ; i>=1 ; i--) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
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
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1 < 1 || num2 < 1) { // 1 미만의 숫자가 입력된 경우
			System.out.println("1 이상의 숫자를 입력해주세요.");
			
		}else {
			
			// 출력을 위한 for문의 초기식, 조거식 값 구하기
			
			// 일단 start에 첫 번째 숫자,  end에 두 번째 숫자를 대입하고
			int start = num1;
			int end = num2;
			
			// 만약 첫 번째 숫자가 크다면 start, end의 값 바꾸기
			if(num1 > num2) {
				start = num2;
				end = num1;
			}
			
			for(int i=start ; i<=end ; i++) {
				System.out.print(i + " ");
			}
		}
		
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
		
		System.out.println("=====" + dan + "단 =====");
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("%d * %d = %d\n", dan , i, dan*i);
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
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		if(input < 2 || input > 9) { // 2~9를 사이가 아닌 수를 입력한 경우
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		
		}else { // 2~9 사이를 입력한 경우
			
			for(int dan=input ; dan<=9 ; dan++) {
				// 입력받은 숫자의 단부터 9단까지 출력
				
				System.out.println("=====" + dan + "단 =====");
				for(int i=1 ; i<=9 ; i++) {
					System.out.printf("%d * %d = %d\n", dan , i, dan*i);
				}
			}
		}
		
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
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int row=1 ; row<=input ; row++) {
			for(int col=1 ; col<=row ; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/*
	실습문제 8
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
			for(int col=1 ; col<=row ; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/*
	실습문제 9
	다음과 같은 실행 예제를 구현하세요.

	ex.
	정수 입력 : 4
	   *
	  **
	 ***
	****
	
	 */
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// for문을 이용한 풀이
		for(int row = 1 ; row <= input ; row++ ) {
			for(int i = input-1 ; i >= row ; i--) {
				System.out.print(" ");
			}
			
			for(int col = 1 ; col <= row ; col++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		System.out.println("===========================");
		
		// if문을 이용한 풀이
		for(int row=1 ; row<=input ; row++) {
			for(int col=1 ; col<=input ; col++) {
				
				if(col <= input - row) {
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
	정수 입력 : 3
	*
	**
	***
	**
	*
	
	*/
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 위쪽 삼각형
		for(int row = 1 ; row <= input ; row++) {
			for(int col = 1 ; col <= row ; col++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		
		// 아랫쪽 삼각형
		for(int row = input - 1; row >= 1 ; row--) {
			for(int col = 1 ; col <= row ; col++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		
		
		System.out.println("====================");
		
		
		for(int row=1; row<= input*2-1; row++) {
         
    	  if(row < input) {
        	  
             for(int col=1; col <= row; col++) {
                System.out.print("*");
             }
             
          } else {
             for(int col=input ; col > row-input; col--) {
                System.out.print("*");
             }
          }
          
          System.out.println();
       }
	}
	
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
		
		for(int row = 1 ; row <= input ; row++) {
			
			for(int col = 1 ; col <= input ; col++) {
				
				// 첫 번째 / 마지막 줄, 칸일 때만 * 출력
				if(row == 1 || row == input || col == 1 || col == input) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	
	/*
	1부터 사용자에게 입력 받은 수까지 중에서
	1) 2와 3의 배수를 모두 출력하고
	2) 2와 3의 공배수의 개수를 출력하세요.
	* ‘공배수’는 둘 이상의 수의 공통인 배수라는 뜻으로 어떤 수를 해당 수들로 나눴을 때
	모두 나머지가 0이 나오는 수
	ex.
	자연수 하나를 입력하세요 : 15
	2 3 4 6 8 9 10 12 14 15 
	count : 2
	*/
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();

		int count = 0;
		
		for(int i = 1; i <= input ; i++) {
			
			// 2의 배수 또는 3의 배수인 경우 출력
			if(i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
				
				// 2와 3의 공배수 == 2로도 나누어 떨어지고, 3으로도 나누어 떨어진다
				if(i % 2 == 0 && i % 3 == 0) {
					count++; // count 증가
				}
			}
		}
		
		System.out.println("\ncount : " + count);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

