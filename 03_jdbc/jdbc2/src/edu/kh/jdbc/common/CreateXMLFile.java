package edu.kh.jdbc.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {
	public static void main(String[] args) {
		
		// XML(eXtensible Markup Language) : 확장된 마크업 언어
		// 											(기술 언어, 기술 형식)
		// -> 단순화된 데이터 기술 형식
		
		// XML에 저장되는 데이터의 형식은 Map(Key : Value) 형식이다.
		// -> Key, Value 모두 문자열(String) 형식
		// -> Map<String, String>
		
		
		// Properties (컬렉션)
		// - Map의 후손 클래스
		// - Key, Value 모두 문자열인 Map (Map<String, String>)
		// -> XML 파일을 읽고, 쓰는데 특화된 메서드 제공
		
		
		Scanner sc = new Scanner(System.in);
		
		// Properties 객체 생성
		Properties prop = new Properties();
		// -> Key, Value가 모두 String 고정이라서 제네릭 선언 X
		
		System.out.print("생성할 파일 이름 : ");
		String fileName = sc.nextLine();
		
		// FileOutputStream 객체 생성
		try {
			FileOutputStream fos = new FileOutputStream( fileName + ".xml" );
			
			// Properties 객체를 이용해서 XML 파일 만들기
			// storeToXML(바이트출력스트림, 설명) : XML 파일 생성
			prop.storeToXML(fos, fileName + ".xml file 입니다.");
			
			System.out.println(fileName + ".xml 파일 생성 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}                  
		
	}
}




