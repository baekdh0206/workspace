package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectDepartmentTtileDAO;
import edu.kh.jdbc.dto.Employee1;

public class JDBCExample3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 부서명을 입력 받아 
		// 해당 부서에 존재하는 사원의
		// 사번, 이름, 급여, 부서명을 
		// 사번 오름차순으로 조회
		
		System.out.print("부서명 입력 : ");
		String departmentTitle = sc.nextLine();
		
		
		// SelectDepartmentTitleDAO 객체 생성
		SelectDepartmentTtileDAO dao = new SelectDepartmentTtileDAO();
		
		List<Employee1> empList = dao.select(departmentTitle);
		
		// 결과 출력
		
		// 일치하는 부서명이 없어서 조회 결과가 없을 경우
		if(empList.isEmpty()) { // empList가 비어있으면 true
								// ==   empList.size() == 0
			System.out.println("일치하는 부서가 없습니다.");
			return;
		}
		
		// 향상된 for문
		for( Employee1 emp : empList ) {
			
			System.out.printf("부서: %s / 사번: %s / 이름: %s / 급여: %d \n",     
							emp.getDepartmentTitle(),
							emp.getEmpId(),
							emp.getEmpName(),
							emp.getSalary());     
		}
		
	}
}
