package edu.kh.variable;

public class Practice {
	
	public static void main(String[] args) {
		
		/* [기본 자료형 8가지]
		 * 
		 * 정수형
		 * byte(1), short(2), int(4)(기본형), long(8, L/l)
		 * 
		 * 실수형
		 * float(4, F/f), double(8)(기본형)
		 * 
		 * 문자형
		 * char(2)
		 * 
		 * 논리형
		 * boolean(1, true/false)
		 * 
		 * 
		 * [컴퓨터 값 처리 원칙]
		 * 같은 자료형끼리만 연산 가능, 결과도 같은 자료형
		 * 
		 * [자동 형변환]
		 * 값의 범위가 다른 자료형끼리의 연산 시
		 * 범위가 작은 자료형을 큰 자료형으로 변환
		 * (컴파일러가 자동으로 진행)
		 * 
		 * [강제 형변환]
		 * 특정한 자료형으로 강제 변환(바꾸고 싶은 자료형을 명시)
		 * 데이터 손실이 발생할 수 있다
		 * */
		
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
//		println() 자동 완성 : "syso" -> ctrl + spacebar -> enter
		System.out.println( iNum1 / iNum2 ); // 2
		System.out.println( (int)dNum ); // 2
		System.out.println( iNum2 * dNum ); // 10.0
		System.out.println( (double)iNum1 ); // 10.0
		System.out.println( (double)iNum1 / iNum2 ); // 2.5
		System.out.println( (int)fNum ); // 3
		System.out.println( (int)(iNum1 / fNum) ); // 3
		
		System.out.println(iNum1 / fNum); // 3.3333333
		System.out.println(iNum1 / (double)fNum); // 3.3333333333333335

 		System.out.println( (int)ch ); // 65
 		
 		System.out.println( iNum1 + ch ); // 75
		
 		System.out.println( (char)(iNum1 + ch) );  // 'K'
 		// ABCDEFGHIJ
 		// KLMN....
		
		
		
		
	}
}
