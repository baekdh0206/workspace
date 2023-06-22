package edu.kh.project.chatting.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.chatting.model.dto.ChattingRoom;
import edu.kh.project.chatting.model.dto.Message;
import edu.kh.project.member.model.dto.Member;

@Mapper
public interface ChattingMapper {
    
    public List<ChattingRoom> selectRoomList(int memberNo);

    public int checkChattingNo(Map<String, Integer> map);

    public int createChattingRoom(Map<String, Integer> map);

    public int insertMessage(Message msg);

    public int updateReadFlag(Map<String, Object> paramMap);

    public List<Message> selectMessageList(int chattingNo);

	public List<Member> selectTarget(Map<String, Object> map);
}
