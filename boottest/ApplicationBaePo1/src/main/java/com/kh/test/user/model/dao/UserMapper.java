package com.kh.test.user.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.user.model.vo.User;

@Mapper
public interface UserMapper {

	User searchId(String userId);

}
