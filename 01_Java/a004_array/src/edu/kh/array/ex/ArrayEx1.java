package edu.kh.array.ex;

import java.util.Scanner;

public class ArrayEx1 {

	/* 배열 (자료구조)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것.
	 * 
	 * - 묶여진 변수들은 하나의 이름(배열명)으로 불러지고
	 *   각각의 변수는 index를 이용해서 구분함
	 * 
	 * - index는 0부터 시작
	 * */
	
	// 배열 기본 사용법 1
	public void ex1() {
		
		// 배열 선언
		int[] arr; 
		// - int 배열을 참조할 공간 할당하고 이를 arr 이라고 부르겠다.
		// * 기본 자료형 8개를 제외한 나머지는 "참조형" 이라고 한다!
		
		
		// 배열 할당
		arr = new int[4];
		// - 새롭게 int형 변수 4개짜리 배열을 생성하고
		//   이를 arr에 대입
		//       -> arr이 해당 배열을 참조
		//       -> 해당 배열을 부를 때 arr 이라고 부르면 됨.
		
		
		// 배열 이용
		
		// 1) 배열 각 요소에 값 대입
		arr[0] = 10;
		arr[1] = 30;
		arr[2] = 20;
		arr[3] = 4;
		
		// 2) 배열 각 요소의 값 얻어오기
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		
		
		// 3) for문 + 배열
		System.out.println("-------------------------");
		
		int sum = 0; // 합계
		for(int i=0 ; i<4 ; i++) {
			System.out.printf("arr[%d] : %d \n", i, arr[i]);
			
			sum += arr[i];
		}
		
		System.out.println(sum);
	}
	
	
	// 배열 기본 사용법2 : 초기화
	public void ex2() {
		
		// 배열 : 같은 자료형의 변수를 하나의 묶음으로 다루는 것
		
		// 1)        3) 2)
		int[] numbers = new int[4];
		// 1) Stack 영역에 int배열을 참조하기 위한 변수 
		//    numbers를 선언
		
		// 2) Heap 영역에 새롭게 int 4칸짜리 배열을 할당
		//   -> index 번호 추가, 기본값(0)으로 초기화
		//    + 시작주소 부여 ex) 0x5123
		
		// 3) Heap 영역에 생성된 배열의 시작 주소(0x5123)를
		//    Stack 영역 참조 변수 numbers에 대입한다.
		//    -> numbers가 배열을 참조함
		
		
		// 1. 정말 numbers에 주소가 저장 되었을까??
		System.out.println(numbers); // [I@6f2b958e (주소로 만든 숫자)
									 // -> 지금은 주소로 봐도 무관
		
		
		// 2. 정말 기본값(0)으로 초기화 되었을까?
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		// -> 컴파일러가 0으로 초기화 하였음을 확인
		
		
		System.out.println("-------------------------------");
		
		// 배열 초기화
		
		// 1) 인덱스를 이용한 초기화
		numbers[0] = 100;
		numbers[1] = 5;
		numbers[2] = 300;
		numbers[3] = 99;

		// breakpoint : debug모드로 실행 시 해당 줄의 코드가 수행되기 전 멈춤
		System.out.println("-------------------------------");
		
		// for문을 이용한 초기화
		
		// ** 배열명.length  :  배열의 길이(칸 수)를 반환 **
		for(int i=0 ; i<numbers.length ; i++) {
			numbers[i] = i * 10 + 1;
		}
		
		System.out.println("------------------------------");
		
		// 선언과 동시에 초기화
		int[] numbers2 = {100, 200, 300, 400, 500, 600};
						// new 구문 생략
		
		System.out.println("------------------------------");
		
	}
	
	
	// 배열 기본 사용법 3
	public void ex3() {
		// 3명의 키를 입력 받아 평균 구하기
		
		// 1번 키 입력 : 170.5
		// 2번 키 입력 : 165.7
		// 3번 키 입력 : 180.4
		
		// 입력 받은 키 : 170.5  165.7  180.4
		// 평균 키 : 172.20cm
		
		Scanner sc = new Scanner(System.in);
		
		double[] heightArray = new double[3]; // 0.0  0.0  0.0
		
		for(int i=0 ; i<heightArray.length ; i++) {
							//3
			System.out.printf("%d번 키 입력 : ", i+1); // 1 2 3
			heightArray[i] = sc.nextDouble();
				// 0 1 2
		}
		
		System.out.println(); // 개행
		
		System.out.print("입력 받은 키 : ");
		
		double sum = 0.0; // 키 합계 저장용 변수
		
		for(int i=0 ; i<heightArray.length ; i++) { 
			// i = 0,1,2
			System.out.print(heightArray[i] + " ");
			sum += heightArray[i]; // 키 누적
		}
		
		System.out.printf("\n평균 키 : %.2fcm", sum / 3 );
		
	}
	
	
	// 배열 기본 사용법 4
	public void ex4() {
		// 오늘의 점심 메뉴 뽑기
		
//		String[] menuArr = new String[10];
		
		String[] menuArr = {"김밥+라면", "서브웨이", "KFC", "맘스터치",
							"순대국", "뼈해장국", "닭갈비", "마라탕",
							"우육면", "파스타"};
		
		// 0 부터 배열 길이의 범위 내에서 난수 발생
		int index =  (int)(Math.random() * menuArr.length);
		
		System.out.println("오늘의 점심 메뉴!! : " + menuArr[index]);
		
	}
	
	
	// 배열 사용 시 주의 사항!!!!
	public void ex5() {
		
		// 배열의 범위를 넘어선 index를 참조하는 경우
		
		
		int[] arr = {10,30,50,70,90};
		
		// arr에 저장된 값 모두 출력
		for(int i=0 ; i <= arr.length ; i++) { // i = 0,1,2,3,4,5
							// 5
			System.out.println(arr[i]);
		}
		
		// Array Index OutOfBounds Exception : Index 5 out of bounds for length 5
		// 배열  인덱스 범위초과   예외(에러)
		// : 인덱스 5번은 길이 5짜리 배열의 범위를 초과했다.
		
		
		// 문제점 : for문의 조건식에서 i의 범위가
		//			arr 배열의 인덱스 범위를 초과하는 값까지 
		//          증가하도록 작성되어
		//			실행 시 for문 내 출력 구문에서
		//			ArrayIndexOutOfBoundsException이 발생함.
		
		
		// 해결 방법 : 조건식을 i < arr.length로 수정하여
		//             i가 배열의 인덱스 범위를 초과하지 않도록함.
	}
	
	
	
}




