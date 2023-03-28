package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dto.Board;

// 데이터 가공 , 트랜잭션 처리
public class BoardService {
	
	private BoardDAO dao = new BoardDAO();

	
	/** 게시글 목록 조회 서비스
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard() throws Exception{
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출
		List<Board> boardList = dao.selectAllBoard(conn);
		
		// 커넥션 반환
		close(conn);
		
		return boardList;
	}


	/** 게시글 상세 조회 서비스
	 * @param input
	 * @param memberNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int input, int memberNo) throws Exception{
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. 게시글 상세 조회 DAO 메서드 호출
		Board board = dao.selectBoard(conn, input);
		
		// 3. 게시글이 조회된 경우
		if(board != null) {
			
			// 4. 조회수 증가 
			// 단, 게시글 작성자와 로그인한 회원이 다를 경우에만 증가
			if( board.getMemberNo()    !=  memberNo ) {
			// 조회한 게시글 회원 번호 != 로그인한 회원 번호
				
				// 5. 조회 수 증가 DAO 메서드 호출(UPDATE)
				int result = dao.updateReadCount(conn, input);
				
				// 6. 트랜잭션 제어 처리 + 데이터 동기화 처리
				if(result > 0) {
					commit(conn);
					
					// 조회된 board의 조회수 0
					// DB의 조회수는 1
					// -> 조회 결과인 board의 조회수도 1 증가
					board.setReadCount( board.getReadCount() + 1 );
					
				}else {
					rollback(conn);
				}
			}
		}
		
		// 7. 커넥션 반환
		close(conn);
		
		// 8. 결과 반환
		return board;
	}


	/** 게시글 수정 서비스
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(String boardTitle, 
				String boardContent, int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		// 게시글 수정 DAO 호출
		int result = dao.updateBoard(conn, boardTitle, boardContent, boardNo);  
		
		// 트랜잭션 처리
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
}
