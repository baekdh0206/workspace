package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {

	public List<Employee2> select(String input) {
		
		// 조회된 사원 정보를 저장할 List
		List<Employee2> empList = new ArrayList<>();
		
		// JDBC 객체 참조 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 객체 메모리에 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 연결 정보
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "kh_bdh";
			String pw = "oracle_bdh123A";
			
			// Connection 얻어오기
			conn = DriverManager.getConnection(url, user, pw);			
			
			String sql = "SELECT NVL(DEPT_TITLE,'부서없음') AS TITLE, JOB_NAME, EMP_NAME, EMAIL "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "JOIN JOB USING (JOB_CODE) "
					+ "WHERE JOB_NAME = '"+input+"' "
					+ "ORDER BY EMP_NAME";
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 조회 결과에 1씩 접근하며 컬럼 값 얻어오기
			while(rs.next()) {
				String departmentTitle = rs.getString("TITLE");
				String jobName = rs.getString("JOB_NAME");
				String employeeName = rs.getString("EMP_NAME");
				String email = rs.getString("EMAIL");
				
				// 얻어온 컬럼 값을 한번에 저장하여 전달할 Eemployee2 객체 생성
				Employee2 emp = new Employee2(departmentTitle, jobName, employeeName, email);
				
				// Employee2 객체를 empList에 추가
				empList.add(emp);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			//  JDBC 객체 자원 반환
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList; // 결과 반환
	}
}
