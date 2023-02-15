package edu.kh.oop.field.pack1;

public class FieldTest1 {
	
	// 필드 작성법
	// [접근제한자] [예약어] 자료형 변수명 [=초기값];
	
	// 접근제한자
	// + public    : 전체, 어디서든지
	// # protected : 같은 패키지 + 패키지 달라도 상속관계면 가능
	// ~ (default) : 같은 패키지 까지 
	// - private   : 현재 클래스에서만
	
	public    int v1 = 10;
	protected int v2 = 20;
			  int v3 = 30;
	private   int v4 = 40;
	
	
	// 접근제한자 확인
	public void ex1() {
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}
}
