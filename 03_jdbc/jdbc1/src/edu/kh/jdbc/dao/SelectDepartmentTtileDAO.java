package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee1;

// DAO (Data Access Object) : 데이터에 접근하기 위한 객체
// == DB 연결 역할 객체
public class SelectDepartmentTtileDAO {
	
	/** 부서명으로 사원 조회
	 * @param departmentTitle
	 * @return empList
	 */
	public List<Employee1> select(String departmentTitle) {
		
		// 조회 결과를 저장하고 반환할 때 사용할 List를 생성
		List<Employee1> empList = new ArrayList<>();
		
		
		// 1단계 : JDBC 객체 참조 변수 선언
		Connection conn = null; // DB 연결 정보 저장. Statement 통로
		Statement stmt = null; // SQL 수행, 결과 반환
		ResultSet rs = null;   //  SELECT 수행 결과 저장용 객체
		
		// 2단계 : 참조 변수에 알맞은 값 대입
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 메모리에 드라이버 객체 로드
			
			// DB 연결 정보
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost"; // DB서버 -> 115.90.212.22
			String port = ":1521"; //   DB서버 -> :9000
			String dbName = ":XE"; // 19c -> :ORCL  ,  18c,DB서버  -> :XE
			String user = "kh_bdh";
			String pw = "oracle_bdh123A";
			
			// DriverManager를 이용해 Connection 생성하여 얻어오기
			conn = DriverManager.getConnection(type+ip+port+dbName, user, pw);    
												//     url
			
			// -- null 입력 시 해결 방법 1: 상황에 따른 SQL 구문 조립
			String condition = null;
			
			if(departmentTitle.toLowerCase().equals("null")) { // null이 입력된 경우
				condition = "WHERE DEPT_TITLE IS NULL ";
			}else {
				condition = "WHERE DEPT_TITLE = '" + departmentTitle + "'";
			}
			
			// SQL 작성
			String sql =  "SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE "
						+ "FROM EMPLOYEE "
						+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
						+ condition
//						+ "WHERE DEPT_TITLE = '" + departmentTitle + "'"
						+ " ORDER BY EMP_ID";
			
//			-- null 입력 시 해결 방법 2: SQL을 바꾸는 방법
//			SELECT * FROM (
//				SELECT EMP_ID, EMP_NAME, SALARY, NVL(DEPT_TITLE, 'null') DEPT_TITLE
//				FROM EMPLOYEE 
//				LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
//				ORDER BY EMP_ID )
//			WHERE DEPT_TITLE = 'null';
			
			
			
			stmt = conn.createStatement(); // Statement 객체 생성
			
			rs = stmt.executeQuery(sql); // SELECT 수행 후 결과 반환 받기
			
			
			// 3단계
			while(rs.next()) { // 커서를 1행씩 이동
							   // 다음 행이 없을 때 까지
//				String empId = rs.getString("EMP_ID");
				String empId = rs.getString(1); // 조회 결과 컬럼 순서
				String empName = rs.getString(2);
				int salary = rs.getInt(3);
				String title = rs.getString(4);

				// 조회된 컬럼 값을 Employee1 객체에 저장
				Employee1 emp = new Employee1(empId, empName, salary, title);
				
				// 컬럼 값이 저장된 객체를 empList에 추가
				empList.add(emp);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4단계 : JDBC 객체 자원 반환
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList; // 조회 결과가 담긴 empList 반환
	}

}
