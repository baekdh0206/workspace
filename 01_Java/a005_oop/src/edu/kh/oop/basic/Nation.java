package edu.kh.oop.basic;

// 현실에서의 객체 : 속성(data)과 기능(method)을 가지고있는 식별 가능한 것

// 클래스 : 객체의 특성(속성, 기능) 정의한 것
//		    일종의 설계도
//			-> 설계도(클래스)는 객체가 아니다!
//			-> 하나의 설계도(클래스)로 여러 객체를 만들 수 있다!

public class Nation {

	// 국민이라면 가지고 있어야하는 공통된 속성(정도, 데이터)
	// -> 추상화(공통점만 추출, 불필요한 요소는 제거)
	
	/* 속성(== 멤버 변수) */
	
	// [캡슐화] 두 번째 특징(원칙)
	// 멤버변수는 private으로 지정
	private String pNo;  // 주민등록번호
	
	String name; // 이름
	char gender; // 성별(남/여)
	String address; // 주소
	String phone; // 전화번호
	int age; // 나이
	
	
	/* 기능(== method)*/
	public void speakKorean() { 
		System.out.println("가나다라 한국말 가능(세종대왕님 만세!!)");
	}
	
	public void medicalBenefits() {
		System.out.println("의료 혜택을 받을 수 있다.");
	}
	
	
	// [캡슐화] 두번째 특징(원칙)
	// private으로 지정된 멤버 변수에 대한
	// 간접 접근 방법(기능)을 작성
	public String getpNo() { // 외부에서 내부 데이터를 얻어가는 방법
		return this.pNo;
	}
	
	public void setpNo(String pNo) {// 외부에서 내부 데이터를 설정하는 방법
		this.pNo = pNo;
	}
	
	
	
	
	
	
	
} // 클래스 내에 객체의 속성, 기능을 묶어놓음
// == [캡슐화] 첫 번째 특징






