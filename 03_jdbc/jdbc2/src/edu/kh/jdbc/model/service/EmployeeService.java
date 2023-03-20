package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.EmployeeDAO;

// Model : 데이터 논리 구조 제어(트랜잭션 제어), 데이터 가공 처리
//			-> (비즈니스 로직)

//         DAO 수행 결과를 View/Controller로 반환 
//  -> 프로그램(앱)에 포함되어야할 데이터에 대한 정의


// Service : 비즈니스 로직
// - 요청에 따른 필요 데이터를 반환
// + 트랜잭션 제어 처리(Commit, Rollback)
public class EmployeeService {

	// dao에 여러 SQL을 수행하기 위한 메서드를 각각 작성하여 호출
	private EmployeeDAO dao = new EmployeeDAO();
	
	
	
	
	
	
}



