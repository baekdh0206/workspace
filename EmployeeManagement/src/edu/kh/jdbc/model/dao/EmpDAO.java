package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
}
