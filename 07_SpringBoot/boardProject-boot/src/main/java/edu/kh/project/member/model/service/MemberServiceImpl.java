package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

	@Autowired // bean으로 등록된 객체 중 타입이 일치하는 객체를 DI
	private BCryptPasswordEncoder bcrypt;

	@Override
	public Member login(Member inputMember) {

		System.out.println("암호화 확인 : " + bcrypt.encode(inputMember.getMemberPw()));


		Member loginMember = dao.login(inputMember);

		if (loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우

			// 입력한 pw, 암호화된 pw 같은지 확인
			// 같을 경우
			if (bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {

				// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
				loginMember.setMemberPw(null);

			} else { // 다를 경우
				loginMember = null; // 로그인 실패처럼 만듦
			}

		}

		return loginMember;
	}


	// 회원 가입 서비스
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public int signUp(Member inputMember) {

		// 비밀번호를 BCrypt를 이용하여 암호화 후 다시 inputMember에 세팅
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);

		// DAO 호출
		int result = dao.signUp(inputMember);

		return result;
	}

}
