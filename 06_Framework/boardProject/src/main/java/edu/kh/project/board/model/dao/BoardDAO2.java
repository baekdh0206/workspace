package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;

@Repository
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시글 삽입
	 * @param board
	 * @return boardNo
	 */
	public int boardInsert(Board board) {
		int result = sqlSession.insert("boardMapper.boardInsert", board);
		// -> sql 수행 후 매개변수 board 객체에는 boardNo 존재 O/X
		
		// 삽입 성공 시
		if(result > 0) result = board.getBoardNo();
		
		return result; // 삽입 성공 시 boardNo, 실패 시 0 반환
	}

	/** 이미지 리스트(여러 개) 삽입
	 * @param uploadList
	 * @return result
	 */
	public int insertImageList(List<BoardImage> uploadList) {
		return sqlSession.insert("boardMapper.insertImageList", uploadList);
	}

	/** 게시글 수정
	 * @param board
	 * @return rowCount
	 */
	public int boardUpdate(Board board) {
		return sqlSession.update("boardMapper.boardUpdate", board);
	}

	/** 이미지 삭제
	 * @param deleteMap
	 * @return rowCount
	 */
	public int imageDelete(Map<String, Object> deleteMap) {
		return sqlSession.delete("boardMapper.imageDelete", deleteMap);
	}

	
	/** 이미지 수정
 	 * @param img
	 * @return rowCount
	 */
	public int imageUpdate(BoardImage img) {
		return sqlSession.update("boardMapper.imageUpdate", img);
	}

	/** 이미지 삽입(1개)
	 * @param img
	 * @return rowCount
	 */
	public int imageInsert(BoardImage img) {
		return sqlSession.insert("boardMapper.imageInsert", img);
	}

	/** 게시글 삭제
	 * @param map
	 * @return result
	 */
	public int boardDelete(Map<String, Object> map) {
		return sqlSession.update("boardMapper.boardDelete", map);
	}
	
	
	
}
