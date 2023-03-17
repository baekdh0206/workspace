package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급명 입력 : ");
		String input = sc.nextLine();
		
		// DAO 생성 후 메서드 호출
		SelectJobNameDAO dao = new SelectJobNameDAO();
		
		List<Employee2> empList = dao.select(input);
		
		// 조회된 사원이 없을 경우
		if(empList.isEmpty()) {
			System.out.println("입력된 직급명과 일치하는 사원이 없습니다.");
			return;
		}
		
		// 조회된 사원이 있을 경우 모두 출력
		for(Employee2 emp : empList) {
			System.out.println(emp);
		}
		
	}
}
