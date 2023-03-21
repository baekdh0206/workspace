package edu.kh.jdbc.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Employee;
import edu.kh.jdbc.model.service.EmployeeService;

// 값 입력 / 출력용 클래스
// -> 사용자와 맞닿는(접점) 클래스 == User Interface (UI)
public class EmployeeView {
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n-----------------------------\n");
				System.out.println("----- 사원 관리 프로그램 -----");
				System.out.println("1. 전체 사원 조회"); // 사번, 이름, 부서명, 직급명, 전화번호
														 // 직급코드 오름차순
				
				System.out.println("2. 사번이 일치하는 사원 조회"); 
				// 사번, 이름, 부서명, 직급명, 전화번호 1행 조회
				
				System.out.println("3. 이름에 글자가 포함된 사원 조회"); 
				// 사번, 이름, 부서명, 직급명, 전화번호 N행 조회
				// 사번 오름차순
				
				System.out.println("4. 급여 범위로 조회");
				// 사번, 이름, 직급명, 급여 조회
				// 급여 내림차순
				// 먼저 입력한 값 이상
				// 나중에 입력한 값 이하
				
				System.out.println("5. 사원 정보 추가");
				// INSERT, SEQUENCE 사용
				
				System.out.println("6. 사번으로 사원 정보 수정");
				// 이메일, 전화전호, 급여 수정

				System.out.println("7. 사번으로 사원 퇴사");
				// ENT_YN = 'Y', ENT_DATE = SYSDATE 수정
				
				// SELECT EMP_ID, EMP_NAME, ENT_YN, ENT_DATE 
				// FROM EMPLOYEE 
				// WHERE EMP_ID = 입력한사번
				
				
				System.out.println("8. 사번으로 사원 정보 삭제");
				// DELETE
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1: selectAll(); break;
				case 2: selectOne(); break;
				case 3: selectName(); break;
				case 4: selectSalary(); break;
				case 5: insertEmployee(); break;
				
				case 6: updateEmployee(); break;
				
				case 7: retireEmployee();  break;
				
				
				case 8: break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while(input != 0);
		
	}
	
	
	
	/**
	 * 전체 사원 조회
	 */
	private void selectAll() {
		// 사번, 이름, 부서명, 직급명, 전화번호
		
		System.out.println("\n----- 전체 사원 조회 -----\n");
		
		try {
			// DB에서 전체 사원 정보를 조회하는 service
			// selectAll()을 호출하여 결과 반환 받기
			List<Employee> empList = service.selectAll();
			
			if(empList.isEmpty()) { // 조회된 사원이 없을 경우
				System.out.println("[사원이 존재하지 않습니다.]");
				return;
			}
			
			// 향상된 for문을 이용해서 모든 사원 정보 출력
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s / %s / %s \n",
						emp.getEmpId(), 
						emp.getEmpName(), 
						emp.getDepartmentTitle(),
						emp.getJobName(),
						emp.getPhone());
			}
			
		}catch (SQLException e) {
			System.out.println("\n[사원 전체 정보 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 사번으로 사원 조회 (1명)
	 */
	private void selectOne() {
		
		System.out.println("\n----- 사번으로 사원 조회 (1명) -----\n");
		
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		try {
			
			// Service 메서드에 사번을 전달해서
			// 사번이 일치하는 사원 정보를 반환
			Employee emp = service.selectOne(input);
			
			if(emp == null) { // 조회 결과 없는 경우
				System.out.println("[일치하는 사번의 사원이 존재하지 않습니다.]");
				return;
			}
			
			// 조회 결과가 있는 경우
			System.out.printf("%d / %s / %s / %s / %s \n",
					emp.getEmpId(), 
					emp.getEmpName(), 
					emp.getDepartmentTitle(),
					emp.getJobName(),
					emp.getPhone());
			
		} catch (SQLException e) {
			System.out.println("\n[사번으로 사원 조회 중 예외 발생.]\n");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 이름에 글자가 포함된 사원 조회
	 */
	private void selectName() {
		System.out.println("\n-----이름에 글자가 포함된 사원 조회-----\n");
		
		// 입력 : 동
		// 200 / 선동일 / 총무부 / 대표 / 01099546325 
		// 213 / 하동운 / 없음 / 대리 / 01158456632 
		
		// 입력 : 선동
		// 200 / 선동일 / 총무부 / 대표 / 01099546325 
		
		// 입력 : a
		// [입력된 글자를 포함하는 이름의 사원이 없습니다.]
		
		// 입력 : 동
		// (SQLException 발생)
		// [글자가 이름에 포함된 사원 조회 중 예외 발생.] 
		
		System.out.print("입력 : ");
		String input = sc.nextLine();
		
		try {
			List<Employee> empList = service.selectName(input);
			
			if(empList.isEmpty()) {
				System.out.println("[입력된 글자를 포함하는 이름의 사원이 없습니다.]");
				return;
			}
			
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s / %s / %s \n",
						emp.getEmpId(), 
						emp.getEmpName(), 
						emp.getDepartmentTitle(),
						emp.getJobName(),
						emp.getPhone());
			}
			
		} catch (SQLException e) {
			System.out.println("[글자가 이름에 포함된 사원 조회 중 예외 발생.] ");
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * 급여 범위로 조회
	 */
	private void selectSalary() {
		System.out.println("\n-----급여 범위로 조회-----\n");
		
		System.out.print("최소 급여 : ");
		int min = sc.nextInt();
		
		System.out.print("최대 급여 : ");
		int max = sc.nextInt();
		
		// DB에서 급여 범위에 해당되는 사원 정보를 조회하는 서비스 호출
		try {
			List<Employee> empList = service.selectSalary(min, max);

			// 조회 결과가 없을 경우 (0행)
			if(empList.isEmpty()) {
				System.out.println("[조회 결과가 없습니다.]");
				return;
			}
			
			// 조회 결과가 있을 경우 (n행)
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s / %d \n",
						emp.getEmpId(), 
						emp.getEmpName(),
						emp.getJobName(),
						emp.getSalary());
			}
			
			
		} catch (SQLException e) {
			System.out.println("\n[급여 범위 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 사원 추가
	 */
	private void insertEmployee() {
		System.out.println("\n-----사원 추가 -----\n");
		
	      System.out.print("이름 : ");
	      String empName = sc.next();
	      
	      System.out.print("주민등록번호 : ");
	      String empNo = sc.next();
	      
	      System.out.print("이메일 : ");
	      String email = sc.next();
	      
	      System.out.print("전화번호(-제외) : ");
	      String phone = sc.next();
	      
	      System.out.print("부서코드(D1~D9) : ");
	      String deptCode = sc.next();
	      
	      System.out.print("직급코드(J1~J7) : ");
	      String jobCode = sc.next();
	      
	      System.out.print("급여등급(S1~S6) : ");
	      String salLevel = sc.next();
	      
	      System.out.print("급여 : ");
	      int salary = sc.nextInt();
	      
	      System.out.print("보너스 : ");
	      double bonus = sc.nextDouble();
	      
	      System.out.print("사수번호 : ");
	      int managerId = sc.nextInt();
	      
	      sc.nextLine(); // 입력 버퍼에 남아있는 개행문자 제거
	      
	      
	      // Employee 객체를 생성하여 입력 받은 값 담기
	      Employee emp = new Employee(empName, empNo, email, phone, salary, 
	    		  				deptCode, jobCode, salLevel, bonus, managerId);

	      
	      // 사원 정보를 DB에 삽입하는 서비스 호출 후 결과 반환 받기
	      try {
			int result = service.insertEmployee(emp);
			
			if(result > 0) { // 성공 시
				System.out.println("[삽입 성공!!!]");
			}else {
				System.out.println("[삽입 실패...]");
			}
			
		} catch (SQLException e) {
			System.out.println("\n[사원 정보 삽입 중 예외 발생]\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 사번으로 사원 정보(이메일, 전화번호, 급여) 수정
	 */
	private void updateEmployee() {
		
		System.out.println("\n-----사번으로 사원 정보 수정 -----\n");
		
		System.out.print("수정할 사원의 사번 : ");
		int empId = sc.nextInt();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("급여 :  ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		
		// 입력 받은 값을 한번에 전달하기 위한 Employee 객체 생성
		
		Employee emp = new Employee();
		
		emp.setEmpId(empId);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setSalary(salary);
		
		// 회원 정보 수정 서비스 호출 후 결과 반환 받기
		try {
			int result = service.updateEmployee(emp);
			
			if(result > 0) { // 성공
				System.out.println("[수정 성공]");
			}else { // 실패
				System.out.println("[수정 실패]");
			}
			
		} catch (SQLException e) {
			System.out.println("\n[회원 정보 수정 중 예외 발생.]\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 사번으로 사원 퇴사
	 */
	private void retireEmployee() {
		System.out.println("\n-----사번으로 사원 퇴사-----\n");
		
		System.out.print("퇴사 처리할 사원의 사번 입력 :");
		int input = sc.nextInt();
		
		System.out.print("정말 퇴사 처리 하시겠습니까?(Y/N) ");
		char check = sc.next().toUpperCase().charAt(0);
		
		if(check == 'N') {
			System.out.println("[취소되었습니다]");
			return;
		}
		
		if(check != 'Y') {
			System.out.println("[잘못 입력 하셨습니다.]");
			return;
		}
		
		// 서비스 호출 후 결과 반환 받기

		// 성공 : [퇴사 처리가 완료 되었습니다]
		// 실패 : [사번이 일치하는 사원이 없습니다]
		// 예외 : [퇴사 처리 중 예외 발생]
		try {
			int result = service.retireEmployee(input);
			
			String str = null;
			
			if(result > 0) 	str = "[퇴사 처리가 완료 되었습니다]";
			else			str = "[사번이 일치하는 사원이 없습니다]";
			
//			if(result > 0) 	System.out.println("[퇴사 처리가 완료 되었습니다]");
//			else			System.out.println("[사번이 일치하는 사원이 없습니다]");
			
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println("\n[퇴사 처리 중 예외 발생]\n");
			e.printStackTrace();
		}
	}
	
	
}

