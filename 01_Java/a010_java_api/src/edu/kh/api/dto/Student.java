package edu.kh.api.dto;

public class Student {

	private int grade;
	private int classRoom;
	private int number;
	private String name;
	
	// 기본 생성자
	public Student() {	}

	
	// 매개변수 생성자
	public Student(int grade, int classRoom, int number, String name) {
		super();
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
	}

	// getter/setter
	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	// toString() 오버라이딩
	@Override
	public String toString() {
		return String.format("%d / %d / %d /%s", grade, classRoom, number, name);
	}
	
	// Object.equals() 오버라이딩
	// -> 현재 객체와 다른 객체가 동등(필드 값이 같은지) 비교
	// -> 필드를 가지고 있는 자식 클래스가
	//    알맞은 형태로 재정의(오버라이딩) 필요
	
	@Override
	public boolean equals(Object obj) {
		
		// 같은 객체를 참조할 경우
		if(this == obj) return true;
		
		// null인 경우 비교 자체가 불필요
		if(obj == null) return false;
		
		// 비교를 위해 전달 받은 객체 Student가 맞는가?
		// false인 경우 실행
		if( !(obj instanceof Student) ) return false;
		
		
		// 필드 비교
		Student other = (Student)obj; // obj 다운 캐스팅
		
		if(this.grade != other.grade) return false;
		if(this.classRoom != other.classRoom) return false;
		if(this.number != other.number) return false;
		if( !this.name.equals(other.name)  ) return false;
		
		return true; // 모든 필드가 같을 경우
	}
	
	
	
	
}
