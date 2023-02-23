package edu.kh.polymorphism.ex2.dto;

// 클래스 상속 : extends (확장하다)
// -> 부모가 가지고 있는 필드와 완성된 메서드를 물려 받아 객체 크기가 확장됨 

// 인터페이스 상속 : implements(구현하다)
// -> 추상 메서드만 물려 받아 강제로 해당 메서드를 구현(오버라이딩) 해야함 

public class HongGilDong implements KH{

	@Override
	public void lesson() {
		System.out.println("A강의장에서 자바 수업 참여");
	}
	
}
