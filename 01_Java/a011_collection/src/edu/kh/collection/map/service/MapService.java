package edu.kh.collection.map.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapService {
	
	public void ex1() {
		/* Map : 특정 키워드(key)를 입력하면 상세한 값(value)이 나온다
		 * 
		 * - Key: Value 형태의 데이터를 모아둔 컬렉션 객체
		 * 
		 * - key만 모아서 봤을 때 Set의 특징을 지님
		 *   --> 중복 X,  순서 유지 X
		 * 
		 * - Value만 모아서 봤을 때
		 *  --> Key로 인해서 값이 구분되기 때문에
		 *      중복 허용 (List의 특징을 지님)
		 * */
		
		
		Map<Integer, String> map = new HashMap<>();
		// Key는 Integer로 제한
		// Value는 String으로 제한
		
		// V put(K k, V v) : Map 추가
		map.put(1, "김밥");
		map.put(2, "라면");
		map.put(3, "떡볶이");
		map.put(4, "돈까스");
		
		System.out.println(map);
		
		// key가 중복되는 경우 -> 덮어 씌움
		map.put(4, "치즈 돈까스");
		System.out.println(map);
		
		
		// V get(K k) : Key에 해당하는 Value 반환
		System.out.println( map.get(3) );
		
		
		// Map에서 key만 묶어보면 Set의 특징을 갖는다
		// + 향상된 for문
		// -> Map에 저장된 모든 객체의 Value만 출력하기
		
		Set<Integer> keys = map.keySet();
		// Set<T> keySet() : key만 모아서 Set 형태로 반환
		
		System.out.println("------------------");
		for(Integer k : keys) {
			System.out.println( k + " : " + map.get(k)  );
		}
	}
	
	
	public void ex2() {
		// Map은 언제 사용하면 좋을까?
		
		// 1) 한 번에 다량의 데이터를 전달해야 하는 경우
		//	  + 데이터의 명확한 구분이 필요한 경우
		
		// 2) DTO(Data Transfer Object) : 값 전달용 객체
		//   -> 재사용성이 적은 DTO를 대체하는 경우 
		
		// 3) 별도의 DTO가 없을 경우
		
		
//		Map<String, Object> member = new HashMap<>();
		Map<String, Object> member = new LinkedHashMap<>();
										// 순서가 유지되는 HashMap
		
		
		// value가 Object 타입
		// -> Object는 모든 클래스 최상위 부모
		//   == 모든 객체의 부모 타입의 참조변수로 사용 가능(다형성)
		//   == value에 어떤 객체든 작성 가능
		
		// member에 값 추가
		member.put("memberId", "mem01");
		member.put("memberPw", "pass01");
		member.put("memberName", "테스트1");
		member.put("memberAge", 23); // Auto Boxing 적용
		member.put("memberGender", 'M');
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		
		
		// id, pw가 member와 모두 일치하면 member 정보 출력
		if( member.get("memberId").equals(id)  ) {
			// value가 Object 타입이기 때문에 
			// equals()는 Object의 equals() 코드와 연결됨 == 정적 바인딩
			
			// 하지만 프로그램 수행 시
			// 실제 참조하는 객체의 타입 String의 equals()로 연결됨
			// == 동적 바인딩
		
			if( member.get("memberPw").equals(pw) ) {
				
				// member의 모든 정보 출력
				for(String key : member.keySet()) {
					System.out.println(key + " : " + member.get(key));
				}
				
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		}else {
			System.out.println("아이디가 일치하지 않습니다.");
		}
		
	}
	
	
	
}
