package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO (Data Access Object) : DB 접근용 객체
public class EmployeeDAO {

	// JDBC 구문이 여러 번 작성될 예정
	// -> JDBC 객체 참조 변수가 계속 작성될 예정
	//    -> 필드로 작성하여 재사용
	
	private Statement stmt;
	private ResultSet rs;
	
	
	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return
	 */
	public List<Employee> selectAll(Connection conn) {
		
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
			
			// 1) SQL 작성
			// 사번, 이름, 부서명, 직급명, 전화번호
			// 직급코드 오름차순
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "NATURAL JOIN JOB\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement(); // Statement 객체 생성
			
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString(5);
				
				Employee emp = new Employee(Integer.parseInt(empId), 
											empName, phone, departmentName, jobName)
				
				empList.add(emp);
			}
			
		}
		
		return null;
	}
	
	
	
	
	
}



