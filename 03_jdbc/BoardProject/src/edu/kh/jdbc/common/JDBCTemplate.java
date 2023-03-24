package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	/* Template : 주형, 양식, 본뜨기 위한 틀
	 * 
	 * JDBCTemplate : JDBC 관련 작업을 위한 코드를 제공하는 클래스
	 * 
	 * - DB 연결을 위한 Connection 생성 구문
	 * - JDBC 객체 자원 반환 구문(close)
	 * - commit, rollback 구문
	 * - auto commit 기능 off
	 * 
	 * 
	 *  * 어디서든 클래스명.메서드명 으로 호출 가능하도록
	 *     public static으로 작성 *
	 * */
	
	// 필드
	private static Connection conn = null;
	// 왜 static 필드?
	// - static 메서드가 참조 가능한 필드는 static 필드 밖에 없기 때문에
	
	
	public static Connection getConnection() {
		
		try {
			
			// 커넥션 객체가 없거나 닫혀있는 경우
			// -> 새로운 연결(커넥션 다시 얻어오기)
			if(conn == null || conn.isClosed()) {
				
				// conn.isClosed() : 커넥션이 close 상태이면 true 반환
				
				Properties prop = new Properties();
				// Map<String, String> 형태, XML 파일 입출력 특화
				
				prop.loadFromXML(  new FileInputStream("driver.xml")  );
				// 스트림을 이용해서 driver.xml 파일을 읽어와 prop에 저장
				
				// prop에 저장된 값을 변수로 따로 저장
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pw = prop.getProperty("pw");
					
				
				// Oracle JDBC Driver 객체 메모리 로드
				Class.forName(driver);
				
				// DriverManager를 이용해 Connection 얻어오기
				conn = DriverManager.getConnection(url, user, pw);
				
				// ** 자동 커밋 비활성화 ** //
				// -> 왜? 개발자가 직접 트랜잭션을 제어하기 위해서
				conn.setAutoCommit(false);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	//--------- close() 구문 ---------
	
	/** Connection close() 메서드
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())	conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** Statement close() 메서드
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())	stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** ResultSet close() 메서드
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed())	rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	
	/** 트랜잭션 Commit 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())	conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}		
	
	
	/** 트랜잭션 Rollback 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())	conn.rollback();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}			
	
}
