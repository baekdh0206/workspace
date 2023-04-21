package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.common.JDBCTemplate;
import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {
	
	// DAO 필드에 생성 (기본 생성자 사용)
	private StudentDAO dao = new StudentDAO();
	
	
	/** 학생 전체 조회
	 * @return stdList
	 * @throws Exception
	 */
	public List<Student> selectAll() throws Exception {
		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		List<Student> stdList = dao.selectAll(conn);
		
		// 3.select는 트랜잭션 제어 처리 필요 없음
		
		// 4. Connection 반환
		close(conn);
		
		// 5. 결과 반환
		return stdList;
	}
	
	
	

}
