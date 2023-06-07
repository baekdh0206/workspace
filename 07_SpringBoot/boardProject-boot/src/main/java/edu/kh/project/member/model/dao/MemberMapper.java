package edu.kh.project.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

//마이바티스 mapper와 연결된 인터페이스임을 명시
//- 해당 인터페이스에 메서드명과 mapper.xml파일의 id가 일치하는 태그가 자동으로 연결됨
//-> 단, mapper.xml파일의 namespcae가 해당 인터페이스의 패키지명+클래스명으로 등록되어 있어야함.
//- @Mapper가 작성된 인터페이스를 사용하면 DAO에서 sqlSessionTemplate 객체를 사용하지 않아도됨
@Mapper
public interface MemberMapper {

	Member login(Member inputMember);
	// 메서드 이름 login -> 연결된 mapper.xml에서 id가 login인 sql이 수행
	
	
	int signUp(Member inputMember);
	
}




