package edu.kh.io.dto;

import java.io.Serializable;

// Serializable
// -> 직렬화가 될 수 있는 객체가 상속 받는 인터페이스
// --> ObjectOutputStream이 객체를 내보낼 때
//    해당 인터페이스를 상속 받은 객체인 경우에만 직렬화 작업 진행

// Serializable을 상속했지만 구현할 메서드가 없다!
// == 마커 인터페이스
//    (표시 용도의 인터페이스)
public class Student implements Serializable{
	
	private String name;
	private int grade;
	private int classRoom;
	private int number;
	private char gender;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int grade, int classRoom, int number, char gender) {
		super();
		this.name = name;
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", classRoom=" + classRoom + ", number=" + number
				+ ", gender=" + gender + "]";
	}
	
}
