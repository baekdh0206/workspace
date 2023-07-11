package edu.kh.project.chatting.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.chatting.model.dto.ChattingRoom;
import edu.kh.project.chatting.model.dto.Message;
import edu.kh.project.member.model.dto.Member;

public interface ChattingService {
    
    List<ChattingRoom> selectRoomList(int memberNo);

    int checkChattingNo(Map<String, Integer> map);

    int createChattingRoom(Map<String, Integer> map);


    int insertMessage(Message msg);

    int updateReadFlag(Map<String, Object> paramMap);

    List<Message> selectMessageList( Map<String, Object> paramMap);

	/** 채팅 상대 검색
	 * @param map 
	 * @return memberList
	 */
	List<Member> selectTarget(Map<String, Object> map);

	/** 이미지 업로드
	 * @param image
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	String uploadImage(MultipartFile image) throws IllegalStateException, IOException ;

}
