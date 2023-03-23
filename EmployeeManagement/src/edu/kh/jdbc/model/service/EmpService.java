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


	/** 사번으로 사원 정보 수정 서비스 
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmployee(Emp emp) throws SQLException {
		
		// 반환형이 int인 이유
		// -> DML 수행 결과는 반영된(성공) 행의 개수 반환
		// --> 행의 개수는 정수형 --> int 사용
		
		Connection conn = getConnection();
		
		int result = dao.updateEmployee(conn, emp);
		
		// DML 수행 -> 트랜잭션 처리
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn); // 커넥션 반환
		
		return result; // 결과 반환
	}


	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check (0: 없는 사원, 1: 퇴직한 사원, 2: 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn, input);
		
		close(conn);
		
		return check;
	}
	
	
	
	
}
