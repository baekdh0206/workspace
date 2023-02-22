package edu.kh.polymorphism.ex1.service;

import java.util.Scanner;

import edu.kh.polymorphism.ex1.dto.Car;
import edu.kh.polymorphism.ex1.dto.LightCar;
import edu.kh.polymorphism.ex1.dto.Truck;

public class CarService {

	// 다형성 : 객체가 다양한 형태를 지님
	
	// - 상속을 이용한 기술로
	//   부모 타입의 참조 변수 하나로
	//   여러 타입의 자식 객체를 참조할 수 있다.
	
	public void ex1() {
		
		// 부모 참조 변수 = 부모 객체
		Car c1 = new Car();
		
		/* 업캐스팅 : 자식 객체 -> 부모 객체로 변함 */
		// -> 자식 객체 내부에 있는 부모 객체를 참조하도록 변함
		
		// 부모 참조 변수 = 자식 객체
		Car c2 = new Truck();
		
		// 부모 참조 변수 = 자식 객체
		Car c3 = new LightCar();
		
		// Truck 객체가 Car로 부터 상속 받은 메서드 사용
		c2.setWheel(10);
		c2.setSeat(3);
		c2.setFuel("경유");
		
		// c2의 자료형이 Car
		// -> Truck 객체를 참조하더라고 Car 부분만 볼 수 있음!
		
		// c2.setWeight(2.5); // c2로 접근 불가능하여 에러
		
		// 부모 타입 참조 변수로 참조 시 
		// 자식 객체의 부모 부분만 참조 가능
	}
	
	
	public void ex2() {
		/* 업캐스팅 : 자식 객체 -> 부모 객체로 변함 */
		
		/* 다운 캐스팅 : 부모 객체 -> 자식 객체로 변함 */
		
		
		// 부모 참조 변수 = 자식 객체(업캐스팅)
		Car c1 = new LightCar();
		
//		c1.print();
//		c1.getDiscountOffer();
		
		// LightCar로 c1을 강제 형변환
		// -> c1이 LightCar 객체를 모두 참조 가능
		// == 다운 캐스팅
		((LightCar)c1).print();
		
		((LightCar)c1).setDiscountOffer(0.7);
		System.out.println(  ((LightCar)c1).getDiscountOffer()  );
		
		
		// 다운 캐스팅 + 얕은 복사(주소만 복사)
		LightCar light1 = (LightCar)c1;
		
		light1.print();
		
	}
	
	
	
	public void ex3() {
		// 다형성(업캐스팅, 다운캐스팅) + 객체 배열
		
		// Car 1차원 배열 == Car 참조변수의 묶음
		Car[] carList = new Car[3]; 
		
		// carList[i] == Car 참조변수
		carList[0] = new Truck(6, 4, "경유", 1); // 업캐스팅
		carList[1] = new LightCar(4, 4, "휘발유", 0.3); // 업캐스팅
		carList[2] = new Car(4, 2, "전기");
		
		
		
		// 향상된 for문 (배열 요소 순차 접근)
		for(Car c : carList) {
			
			System.out.println("바퀴 수 : " + c.getWheel());
			System.out.println("좌석 수 : " + c.getSeat());
			System.out.println("연료 형식 : " + c.getFuel());
			
			// Truck일 경우 -> 최대 적재 하중 : 2.5 t
			// LightCar일 경우 -> 할인율 : 30%
			// Car일 경우 -> 차종이 등록되어있지 않습니다.
			
			
			/* instanceof 연산자 */
			// - 참조하는 객체의 타입을 검사하는 연산자
			
			// ex)  참조변수명 instanceof 클래스명
			//  -> 참조변수가 참조하는 객체 타입과 
			//     클래스의 타입이 일치하면 true, 아니면 false
			
			if( c instanceof Truck ) {
				// c가 참조하는 객체가 Truck 객체인경우
				
				System.out.println("최대 적재 하중 : " 
									+ ((Truck)c).getWeight());   
				
				// 만약 다운 캐스팅이 잘못될 경우
				// ClassCastException이 발생한다!
				// ex) LightCar 객체를 Truck 참조변수가 참조하려고 할 때
				
				// 해결 방법 : 
				// instanceof를 통해 참조하는 객체의 자료형을 판단하여
				// 적절한 형식으로 다운 캐스팅 진행
			
			} else if(c instanceof LightCar) {
				// c가 참조하는 객체가 LightCar일 경우
				System.out.println("할인율 : " 
							+ ((LightCar)c).getDiscountOffer() * 100 + "%");
			
			} else {
				// c가 참조하는 객체가 Truck, LightCar가 아닐 때
				System.out.println("차종이 등록되어있지 않습니다.");
			}
			
			
			System.out.println("---------------------------------------");
			
		}
		
	}
	
	
	
	public void ex4() {
		
		// 객체배열 + 다형성(업캐스팅/다운캐스팅) + instanceof
		//  + 매개변수 다형성 + 바인딩(정적/동적)
		
		
		// Car 1차원 배열 == Car 참조변수의 묶음
		Car[] carList = new Car[3]; 
		
		// carList[i] == Car 참조변수
		carList[0] = new Truck(6, 4, "경유", 1); // 업캐스팅
		carList[1] = new LightCar(4, 4, "휘발유", 0.3); // 업캐스팅
		carList[2] = new Car(4, 2, "전기");
		
		for(Car c : carList) {
//			printCar(Car객체 주소 또는 Car를 상속 받은 객체 주소);
			printCar(c);
		}
		
		//printCar(new Truck());
	}
	
	// 차량 정보를 출력하는 메서드
	public void printCar(Car c) {
		String type = null;
		
		// 매개변수로 전달 받은 c가 참조하는 객체에 따라서
		// type의 값을 지정.
		
		if(c instanceof Truck)  type = "[Truck]";
		else if (c instanceof LightCar) type = "[LightCar]";
		else  type = "[Car]";
		
		System.out.println(type + "에 대한 정보입니다.");
		
		System.out.println(c.toString());
		// String edu.kh.polymorphism.ex1.dto.Car.toString()
		
		// 바인딩 : 메서드 호출 구문과 
		//          수행될 메서드를 연결 하는 것 (묶는 것)
		
		// 정적 바인딩 
		// - "프로그램 실행 전" 컴파일 단계에서
		//   메서드 호출부화 수행될 메서드를 묶는 것
		
		// - 참조변수의 자료형을 기준으로 연결함
		
		
		// 동적 바인딩
		// - "프로그램 실행 중"
		//   실행할 당시의 객체의 자료형을 기준으로 
		//   메서드 호출부와 수행될 메서드를 묶는 것
		
		// - 참조하는 객체의 자료형을 기준으로 연결함
		
		
		
		
	}
	
	// 출력화면 예상
	/* [Truck]에 대한 정보입니다.
	 * 
	 * 
	 * [LightCar]에 대한 정보입니다.
	 * 
	 * 
	 * [Car]에 대한 정보입니다.
	 * 
	 * */
	
	
	public void ex5() {
		// 반환형의 다형성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생성할 자동차 종류를 선택하세요");
		System.out.println("1. 트럭");
		System.out.println("2. 경차");
		System.out.println("3. 자동차");
		
		Car c = createCar(sc.nextInt());
		
		System.out.println("차가 생성되었습니다.");
		
	}
	
	// 반환형에 다형성(업캐스팅) 적용
	public Car createCar(int num) {
		
		switch(num) {
		case 1 :  return new Truck();
		case 2 :  return new LightCar();
		case 3 :  return new Car();
		}
		
		return null;
	}
	
	
	
	
	
}
