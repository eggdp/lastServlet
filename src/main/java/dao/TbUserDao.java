package dao;

import java.sql.*;


import dto.TbUser;

public interface TbUserDao {
	// 회원가입
	public void join(TbUser user); // 가져온 데이터 입력
	
	// 로그인 처리
	public TbUser selectLogin(String userid, String userpw);
	// 아이디 체크
}
