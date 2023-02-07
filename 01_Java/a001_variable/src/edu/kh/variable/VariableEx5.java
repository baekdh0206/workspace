package edu.kh.variable;

public class VariableEx5 {
	
	public static void main(String[] args) {
		
		/* 형변환(Casting) : 값의 자료형을 변환하는 것
		 * 
		 * 형변환은 왜 필요한가?
		 * -> 컴퓨터의 값 처리 원칙을 위배하는 경우를 해결하기 위해 필요
		 *   (같은 자료형끼리 연산, 결과도 같은 자료형)
		 * 
		 * [자동 형변환]
		 * - <값의 범위>가 서로 다른 두 값의 연산 시
		 *   <컴파일러(번역기)>가 자동으로
		 *   <값의 범위>가 작은 자료형을 큰 자료형으로 변환
		 * */
		
		// 자동 형변환 확인 1
		int num1 = 10;
		long num2 = 100L;
		
		System.out.println("num1 + num2 = " + (num1 + num2) );
											// int  + long
											//  10  + 100L
											// long + long  
											//  10L + 100L
		
		// 자동 형변환 확인 2
		int num3 = 300;
		double num4 = 12.3;
		
		// 연산 결과를 예상해서 저장할 변수의 자료형을 선택
		double result1 = num3 + num4;
		// 300(int) + 12.3(double)
		// -> 300.0(double) + 12.3(double)
		// -> 312.3(double);
		
		System.out.println(num3 + " + " + num4 + " = " + result1 );
		
		
		// 자동 형변환 확인 3
		// char -> int 자동형변환
		
		char ch5 = 'ㄱ';
		
		// =  : 대입 연산자 (대입도 연산이다!)
		int num5 = ch5; // int = char
						// -> int = int (자동 형변환)
		
		System.out.println(ch5 + " Unicode Number : " + num5);
		
		
		System.out.println("----------------------------");
		
		/* [강제 형변환]
		 * - 값의 범위가 큰 자료형을 작은 자료형으로 강제 변환
		 * 
		 * + 변수나 값을 원하는 형태의 자료형으로 강제 변환
		 *   (값의 범위 상관 X)
		 * */
		
		// 강제 형변환 확인 1 : 데이터 손실 확인
		int test1 = 290;
		byte test2 = (byte)test1; // Type mismatch: cannot convert from int to byte
				// 변환 시키고자 하는 자료형을 명시해서 강제 변환
		
		System.out.println("test1 : " + test1);
		System.out.println("test2 : " + test2);
		
		// ctrl + alt + 방향키 위/아래 : 라인 복사
		// 화면 뒤집힐 경우!
		// -> 인텔HD그래픽 -> 그래픽 옵션 -> 바로가기키 -> 사용 안함
		
		
		
		// 강제 형변환 확인 2 : 소수 버림
		double test3 = -1.3;
		int test4 = (int)test3;
		
		System.out.println("test3 : " + test3);
		System.out.println("test4 : " + test4);
		
		
		// 강제 형변환 확인 3 : 값의 범위 관계없이 변환
		int test5 = 1;
		int test6 = 2;
		
		System.out.println(test5 / test6);
						//    1  /  2  = 0.5 (double)
						//   int / int = int (컴파일러가 강제 형변환, 소수 버림)
	
		
		// 자동 형변환 + 강제 형변환
		System.out.println(  (double)test5 / test6 );
							// 강제 형변환
							// -> 1.0(double) / 2(int)
							//					-> 2.0(double) 자동 형변환
							// 1.0 / 2.0 = 0.5
		
		
		System.out.println("-------------------------");
		// 강제 형변환 기타 등등...
		
		// - 변수에만 강제 형변환이 가능한 것은 아니다!
		System.out.println( (double)65 ); // 65.0
		System.out.println( (char)65 ); // A
		System.out.println( (int)'B' ); // 66
		
		
		// 데이터 오버플로우
		
		byte bNum = 126;
		
		System.out.println(bNum); // 126
		
		bNum = (byte)(bNum + 1);
		//		(byte)((int)127)
		
		System.out.println(bNum); // 127
		
		bNum = (byte)(bNum + 1);
		//		(byte)128
		System.out.println(bNum); // -128 (오버플로우 발생)
		
		
		// 오버플로우 확인
		int iNum1 = 1000000000; // 10억
		int iNum2 = 2000000000; // 20억
		
		int iNum3 = iNum1 + iNum2; // 30억이 나와야되지만 .....
		
		// 해결 방법
		//long iNum3 = (long)iNum1 + iNum2;
		
		
		System.out.println(iNum3);
		
		// ** 값의 범위를 잘못 예측한 경우 오버플로우가 발생함!! **
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
