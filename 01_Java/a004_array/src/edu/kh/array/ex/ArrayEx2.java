package edu.kh.array.ex;

public class ArrayEx2 {

	// 2차원 배열 사용법 1
	public void ex1() {
		
		// 2차원 배열 선언 및 할당
		int[][] arr = new int[2][3]; // 2행 3열
		
		System.out.println("행의 길이 : " + arr.length);
		System.out.println("열의 길이 : " + arr[0].length);
		
		// 2차원 배열 초기화
		// 1) 인덱스를 이용한 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21 ;
		
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		System.out.println("-----------------------");
		
		// 2) 2중 for문을 이용한 초기화 방법
		
		int number = 0;
		
		for(int row=0 ; row<arr.length ; row++) { // 행 반복
			for(int col=0 ; col<arr[0].length ; col++) { // 열 반복
				
				arr[row][col] = number * 5;
				number++;
			}
		}
		
		System.out.println("----------------------");
		
		// 3) 선언 및 초기화
		
		int[][] arr2 = { 
						 {1,2,3,4,5},
					     {60,70,80,90,100},
					     {11,22,33,44,55} 
				       };
		
		System.out.println(arr2[1][3]); // 90
		
		
		// 0행 : 1 2 3 4 5
		// 1행 : 60 70 80 90 100
		// 2행 : 11 22 33 44 55
		
		System.out.println("-------------------");
		
		for(int row=0 ; row<arr2.length ; row++) {
			
			System.out.print(row + "행 : ");
			
			// 한 행의 있는 모든 열의 값 출력
			for(int col=0 ; col<arr2[row].length ; col++) {
				System.out.print(arr2[row][col] + " ");
			}
			
			System.out.println(); // 개행
		}
	}
	
	
	
	
	
}
