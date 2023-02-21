package edu.kh.inheritance.dto;

public class Child2 extends Parent{

	private String house;
	
	public Child2() {
		System.out.println("Child2() 기본 생성자");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자");
	}
	
	public String getHouse() {
		return house;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
	public String toString() {
		return house;
	}
	
	
}
