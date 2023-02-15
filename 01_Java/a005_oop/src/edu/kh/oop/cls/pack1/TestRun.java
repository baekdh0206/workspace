package edu.kh.oop.cls.pack1;

import edu.kh.oop.cls.pack2.Test2;

public class TestRun {
	public static void main(String[] args) {
		
		// Test1 클래스를 이용해서 객체 생성
		Test1 t1 = new Test1();
		
		// Test2 클래스를 이용해서 객체 생성
		Test2 t2 = new Test2();
		
		t1.testMethod1();
		t2.testMethod2();
	}
}

// 하나의 .java파일에 여러 class 작성 가능
class Test3{
	
	// 내부 클래스
	class Test4{
		
	}
}








