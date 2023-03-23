package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	/** 재직 중인 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectCurrentEmployee(Connection conn) throws SQLException{
		
		// 결과 저장용 객체
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, EMAIL,\r\n"
					+ "NVL(DEPT_TITLE, '없음') DEPT_TITLE, \r\n"
					+ "NVL(PHONE, '없음') PHONE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE";
			
			// Statement 객체 이용
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 조회 결과를 1행씩 접근
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String departmentName = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				int salary = rs.getInt("SALARY");
				
				Emp emp = new Emp();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(departmentName);
				emp.setJobName(jobName);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setSalary(salary);
				
				// List에 담기
				empList.add(emp);
			}
			
		}finally {
			// JDBC 객체 자원 반환
			close(rs);
			close(stmt);
			
		}
		
		return empList;
	}
	
	
	/** 퇴직한 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetireEmployee(Connection conn) throws SQLException{
		
		// 결과 저장용 객체
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, EMAIL,\r\n"
					+ "	NVL(PHONE, '없음') PHONE,\r\n"
					+ "	TO_CHAR(ENT_DATE, 'YYYY\"년\" MM\"월\" DD\"일') ENT_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE ";
			
			// Statement 객체 이용
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 조회 결과를 1행씩 접근
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String entDate = rs.getString("ENT_DATE"); // TO_CHAR로 형변환 해서 조회
				
				Emp emp = new Emp();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setEntDate(entDate);
				
				// List에 담기
				empList.add(emp);
			}
			
		}finally {
			// JDBC 객체 자원 반환
			close(rs);
			close(stmt);
			
		}
		
		return empList;
	}


	/** 사번이 일치하는 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, EMAIL, HIRE_DATE, ENT_YN,\r\n"
					+ "NVL(DEPT_TITLE, '없음') DEPT_TITLE, \r\n"
					+ "NVL(PHONE, '없음') PHONE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE EMP_ID = ?";
					// placeholder 존재 -> PreaparedStatement 사용
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();

			if(rs.next()) { // 조회 결과가 있어도 1행 밖에 없음 -> if문 사용
				emp = new Emp();
				
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setJobName(rs.getString("JOB_NAME"));
				emp.setDepartmentTitle(rs.getString("DEPT_TITLE"));
				emp.setSalary(rs.getInt("SALARY"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				emp.setEntYN(rs.getString("ENT_YN"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return emp; // 조회 결과가 있으면 null이 아님
					// 조회 결과가 없으면 null
	}


	/** 사번이 일치하는 사원 정보 수정 SQL 수행 후 결과 반환
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmployee(Connection conn, Emp emp) throws SQLException {

		// 1. 결과 저장용 변수/객체 선언
		int result = 0;

		try {
			
			// 2. SQL 구문 작성
			//    PreparedStatement / Statement 생성
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET PHONE = ?,\r\n"
					+ "    EMAIL = ?,\r\n"
					+ "    SALARY = ?,\r\n"
					+ "    BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getPhone());
			pstmt.setString(2, emp.getEmail());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			
			// 3. 수행 후 결과 반환 받아 결과 저장용 변수에 저장
			//  SELECT문 :  executeQuery([SQL]) 
			//  DML문    :  executeUpdate([SQL]) 
			//  [SQL] 작성하는 경우 : Statement 객체 사용 할 때
			result = pstmt.executeUpdate();
			
			
		} finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5. 결과 반환
		return result;
	}


	/** 존재하는 사원인지, 퇴직한 사원인지 조회하는 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException {
		int check = 0;
		
		try {
			String sql = "SELECT CASE \r\n"
					+ "	WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0\r\n"
					+ "	THEN 0\r\n"
					+ "	WHEN (SELECT COUNT(*) FROM EMPLOYEE \r\n"
					+ "		  WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1\r\n"
					+ "	THEN 1\r\n"
					+ "	ELSE 2\r\n"
					+ "	END \"CHECK\"\r\n"
					+ "FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return check;
	}


	/** 퇴직 처리 SQL 수행
	 * @param conn
	 * @param input
	 * @throws SQLException
	 */
	public void retireService(Connection conn, int input) throws SQLException {
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET ENT_YN = 'Y',\r\n"
					+ "	ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			pstmt.executeQuery();
			
		}finally {
			close(pstmt);
		}
		
	}


	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException {

		// 1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, \r\n"
					+ "	COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();
										// 입력 순서가 유지되는 Map
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				// Map을 List에 추가
				mapList.add(map);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		// 5. 결과 반환
		return mapList;
	}
	
	
	
}
