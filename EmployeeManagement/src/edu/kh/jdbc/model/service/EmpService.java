package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/** 재직 중인 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectCurrentEmployee() throws SQLException {

		Connection conn = getConnection(); // 커넥션 생성
		List<Emp> empList = dao.selectCurrentEmployee(conn); // dao 호출
		close(conn);
		return empList;
	}
	
	
	/** 퇴직한 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetireEmployee() throws SQLException {
		
		Connection conn = getConnection(); // 커넥션 생성
		List<Emp> empList = dao.selectRetireEmployee(conn); // dao 호출
		close(conn);
		return empList;
	}


	/** 사번이 일치하는 사원 정보 반환 서비스
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		Emp emp = dao.selectOne(conn, input);
		
		close(conn);
		
		return emp;
	}
	
	
	
	
	
	
}
