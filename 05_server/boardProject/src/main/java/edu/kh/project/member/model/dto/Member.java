package edu.kh.project.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 라이브러리 : getter/setter, 생성자, toString() 자동완성 라이브러리
/*
 	lombok 라이브러리 이클립스 연동하기
	
	1. cmd로 lombok.jar 위치로 이동
	cd 경로
	
	2. java -jar lombok.jar  실행
	
	3. 이클립스 경로 지정(Specify locaction...)
	
	4. Install/update 
 */

@NoArgsConstructor	// 기본 생성자
@AllArgsConstructor // 모든 필드에 대한 매개변수 생성자
@Getter
@Setter
@ToString
public class Member {
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberTel;
	private String memberAddress;
	private String profileImage;
	private String enrollDate;
	private String memberDeleteFlag;
	private int authority;
}
