package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	private PreparedStatement pstmt;
	// Prepared : 준비된
	// -> 외부 변수(값)를 SQL에 삽입할 준비가된 Statement
	
	// PreparedStatement는 Statement 클래스의 자식 클래스로
	// SQL 구문에 ? 기호를 작성해서 
	// SQL에 작성되어지는 리터럴 값을 동적으로 제어하는 기능을 가지고 있다.
	
	// ( ?기호 = placeholder )

	
	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {
		
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
											empName, phone, departmentName, jobName);
				
				empList.add(emp); // 리스트 추가
			}
			
		} finally {
			
			// catch문 -> throws 구문으로 예외 처리
			
			// 4. JDBC 객체 자원 반환 (단, conn 빼고)
			close(stmt);
			close(rs);
		}
		
		// 5. 결과 반환
		return empList;
	}


	/** 사원 1명 정보 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException {
		
		// 1. 결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		// -> 조회 결과가 있을 경우에 객체 생성
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과가 있는지 확인 후 == 1행 조회 성공
			// 있으면 Employee 객체 생성 후 emp에 대입
			if(rs.next()) {
				int empId = rs.getInt(1);
				// DB에서 값을 얻어올 때
				// "숫자" (문자열로된 숫자) 형태일 경우
				// getInt() 를 작성하면 자동으로 int 형변환 진행
				
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				// 객체 생성해서 emp에 대입
				emp = new Employee(empId, empName, phone, departmentName, jobName);
			}
			
			// if(조건식){ true 이면 수행 }  -->  1번 수행
			
			// while(조건식){ true 이면 수행 } + 반복
			// --> 1행만 조회되면 1번 수행
			// --> 불필요한 검사를 진행할 수 있다
			//  ---> 1행 조회에서는 if문 권장!
			
		}finally {
			// 4. JDBC 객체 자원 반환 (conn 빼고)
			close(rs);
			close(stmt);
		}
		
		// 5. 결과 반환
		return emp;
	}


	/** 글자 포함 이름 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectName(Connection conn, String input) throws SQLException{
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, \r\n"
					+ "	JOB_NAME, NVL(PHONE, '없음') PHONE\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE EMP_NAME LIKE '%"+input+"%'\r\n"
					+ "ORDER BY EMP_ID";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				empList.add(new Employee(empId, empName, phone, departmentName, jobName));
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return empList;
	}


	/**  급여 범위 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param min
	 * @param max
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectSalary(Connection conn, int min, int max) throws SQLException{  
		
		// 1. 결과를 저장할 변수/객체 선언
		List<Employee> empList = new ArrayList<>();
		
		try {
			/*
			// 2. Statement, ResultSet 객체를 생성해서 대입
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE SALARY BETWEEN "+min+" AND "+max+"\r\n"
					+ "ORDER BY SALARY DESC";
			
			// SQL을 수행하고 결과를 반환 받을 Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL(SELECT) 수행 후 결과(ResultSet) 반환 받아 저장
			rs = stmt.executeQuery(sql);
			*/
			
			//-----------------------------------------------------------
			
			// ** 2. PreparedStatement 사용하기 **
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE SALARY BETWEEN ? AND ?\r\n"
					+ "ORDER BY SALARY DESC";
			// -> 값이 동적으로 추가되는 부분을 ?기호(placeholder)로 작성
			
			// SQL을 수행하고 결과를 반환 받을 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			 
			// PreparedStatement에 추가된 SQL 구문에서
			// 미완성된(?) 부분에 알맞은 값을 추가
			
			// pstmt.set자료형(순서, 값)
			// -> 순서번째 ?에 값을 세팅
			//    (자료형은 값에 맞게 지정)
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			
			// 준비가 완료된 PreparedStatement를 이용해서 
			// SQL 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			// -> PreparedStatement 객체 생성 시
			//    SQL을 담겨져 있기 때문에 
			//    SQL 수행 구문에서 따로 매개변수를 작성하지 않는다!
			
			// 3. 커서를 이용해서 조회 결과를 1행씩 접근
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				// Employee 객체를 생성해서 컬럼 값을 세팅
				// (기본 생성자 + setter)
				
				Employee emp = new Employee();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				
				// empList에 추가
				empList.add(emp);
			}
			
		} finally {
			// 4. JDBC 객체 자원 반환 (생성 역순 권장)
			close(rs);
			close(stmt);
		}
		
		// 5. 결과 반환
		return empList;
	}


	/** 사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Employee emp) throws SQLException {
		
		// ** DML 수행 시 영향을 끼친 행의 개수가 반환된다!!! **
		// (삽입된 행의 개수, 수정된 행의 개수, 삭제된 행의 개수)
		// -> 행의 개수 == 숫자(정수) == int 사용
		
		// 1. 결과를 저장할 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreparedStatement 객체 생성
			
			// 1) SQL 작성
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			
			// 2) PreparedStatement 객체 생성 후 placeholder에 값 세팅
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			// 3. SQL 수행 후 결과 반환 받기
			// executeQuery() : SELECT 수행 후 ResultSet 반환
			// executeUpdate() : DML 수행 후 결과 행의 개수 반환
			result = pstmt.executeUpdate();
			
			// ** SELECT와 다르게 옮겨 담는 과정이 없다! ** 
			
		}finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
			// -> Statement를 close() 하는 메서드 호출
			//    (매개변수에 다형성 업캐스팅 적용)
		}
		
		// 5. 결과 반환
		return result;
	}


	/** 사원 정보를 수정하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmployee(Connection conn, Employee emp) throws SQLException {
		
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreaparedStatement 생성
			
			// 1) SQL 작성
			String sql = "UPDATE EMPLOYEE \r\n"
						+ "SET EMAIL = ?,  \r\n"
						+ "	PHONE = ?,  \r\n"
						+ "	SALARY = ?  \r\n"
						+ "WHERE EMP_ID = ?";
			
			// 2) PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getEmpId());
			
			// set자료형() 으로 ?에 값을 세팅할 때
			// 자료형에 맞는 DB 리터럴 표기법으로 변환되서 세팅된다!
			
			// setString()  -> 'hong_gd@naver.com'
			// setInt()     -> 1200000
			// setDouble()  -> 0.2
			// setDate(순서, java.sql.Date)  -> DB DATE 타입
			
			
			// 3. 수행 후 결과 반환 받기
			result = pstmt.executeUpdate();
									// 매개변수에 SQL 작성 X
			
		}finally {
			
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5. 결과 반환
		return result;
	}


	/** 퇴사 처리 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int retireEmployee(Connection conn, int input) throws SQLException {
		
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			
			// 2. SQL 작성 + PreaparedStatement 객체 생성 후 값 세팅
			String sql = "UPDATE EMPLOYEE\r\n"
						+ "SET ENT_YN = 'Y',\r\n"
						+ "    ENT_DATE = SYSDATE\r\n"
						+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			// 3. SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate(); // 1행 성공, 0행 성공
			
		}finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5. 결과 반환
		return result;
	}
	
	
	
	
	
}



