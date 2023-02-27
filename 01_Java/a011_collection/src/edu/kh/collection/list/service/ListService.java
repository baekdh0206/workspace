package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

public class ListService {
	
	/* List : 자료들을 순차적으로 나열한 자료구조 (배열과 비슷함)
	 * 
	 * - 인덱스를 이용해서 순서를 유지
	 * - 순서 구분이 가능하기 때문에 중복되는 데이터를 저장할 수 있다.
	 * 
	 * List 인터페이스를 구현한 대표적인 클래스
	 * -> ArrayList, Vector, LinkedList
	 * */
	
	
	public void ex1() {
		
		/* 컬렉션 특징
		 * 1) 크기 제약이 없다.
		 * 2) 추가, 삭제, 수정 등의 기능이 구현되어있다.
		 * 3) 여러 타입의 객체를 저장할 수 있다.
		 *   -> Object 타입의 참조변수 묶음이기 때문에.
		 * */
		
		// ** 컬렉션은 모두 java.util 패키지에 존재 **
		// utility : 유용
		
		//ArrayList list = new ArrayList(); // 기본 생성자 -> 10칸짜리 생성
		
		ArrayList list = new ArrayList(3); // 매개변수 생성자 -> 3칸짜리 생성

		// -> 예상되는 데이터 수에 따라 생성자를 골라서 사용
		//  -> 생성자에 따라 속도, 메모리 효율이 달라짐  
		
		
		// boolean add(E e) : 리스트 마지막에 요소 추가
		// * E(Element) : 요소(객체)를 의미하는 제네릭 표기법
		//				 == Object 타입으로 생각하면 됨.
		
		list.add("아무거나");
		list.add(123); // Integer로 저장
		list.add(3.14); // Double로 저장
						// -> Auto Boxing
		
		list.add("초과"); // List 범위 3 초과
						  // -> 자동으로 크기 증가
		
		// void add(int index, E e) : 원하는 index 위치에 요소 추가
		
		list.add(1, "중간 삽입");
		
//		list.add(10, "삽입"); // 오류 발생
		
		
		// E get(int index) : 주어진 index의 요소를 반환
		// int size() : 리스트 크기 X, 리스트에 저장된 요소의 개수 O 
		
//		System.out.println(list.get(3));

		for( int i=0 ; i<list.size() ; i++ ) {
			
			System.out.println(list.get(i));
			
			//* 컬렉션에서 여러 데이터 타입을 저장할 경우의 단점 *
			// - 각 요소마다 타입이 다르기 때문에
			//   원하는 코드가 있을 경우 타입 검사 + 다운 캐스팅이 강제됨
			
			if(list.get(i) instanceof String) { // 요소가 String인 경우
				char ch = ((String)list.get(i)).charAt(0); 
				System.out.println("ch : " + ch);
			
			} else if (list.get(i) instanceof Integer) { // 요소가 Integer인 경우
				int max = ((Integer)list.get(i)).MAX_VALUE;
				System.out.println("max : " + max);
			
			} else if(list.get(i) instanceof Double) {
				double min = ((Double)list.get(i)).MIN_VALUE;
				System.out.println("min : " + min);
			}
		}
		
		
		System.out.println("---------------");
		
	}
	
	
	public void ex2() {
		
		// 제네릭을 이용한 컬렉션 타입 체크
		// -  <타입> 형식으로 작성
		
		List<String> list = new ArrayList<String>();
		// String으로 타입이 제한된 ArrayList 객체를 생성하여
		// 부모 타입인 List로 참조
		
		// 컴파일 단계에서 타입 체크 
		// -> 컬렉션에 사용되는 객체의 타입이 
		//    컬렉션 생성 시 지정된 타입과 같은지 확인
		//    + 자동으로 다운캐스팅 진행
		// boolean list.add(String e)
		
		list.add("그만좀");
		list.add("졸아라");
		list.add("누군지 아시죠??");
		
		for(int i=0 ; i<list.size(); i++) {
			String str = list.get(i); // 다운캐스팅 필요 X
			System.out.println(str.charAt(0));
		}
		
		System.out.println("--------------");
		
		// 향상된 for문
		// - 배열/컬렉션의 모든 요소를 순차적으로 접근하는 반복문
		for(String s : list) {
			System.out.println(s);
		}
		
		
	}
	
	
	
	
}
