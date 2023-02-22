package edu.kh.inheritance.dto;

public class Child2 extends Parent{
// The type Child2 cannot subclass the final class Parent
	private String house;
	
	public Child2() {
		System.out.println("Child2() 기본 생성자");
	}
	
	public Child2(String house) {
		super();
		
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자");
	}
	
	public String getHouse() {
		return house;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
	
	// 부모의 getMoney() 존재
	/*
	public int getMoney() {
		return money;
	}
	*/
	
	// 자식이 상속 받은 getMoney()을 다시 작성(재정의)
	
	// @Override : 컴파일러에게 해당 메서드는 재정의 되었다는 것을
	//			   알려주는 컴퓨터용 주석
	//			   -> 오버라이딩 형식이 맞는지 검사 진행
	
	// 오버라이딩 성립 조건
	
//	- 메소드 이름 동일
//	- 매개변수의 개수, 타입, 순서 동일
//	- 리턴 타입 동일
//	- private 메소드 오버라이딩 불가
//	- 접근 제어자는 부모와 같거나 넓은 범위로 변경 가능
//	- 예외처리는 부모와 같거나 좁은 범위로 예외처리 변경 가능
	@Override
	public int getMoney() {
		// Cannot override the final method from Parent
		
		System.out.println("자식이 오버라이딩한 getMoney()");
		return super.getMoney() + 500; 
		// 부모의 getMoney() 반환값에 500원 추가
	}
	
	
	
}
