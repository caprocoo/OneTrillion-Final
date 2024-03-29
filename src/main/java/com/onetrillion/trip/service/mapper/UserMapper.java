package com.onetrillion.trip.service.mapper;

import java.util.List;


import com.onetrillion.trip.user.UserDTO;

public interface UserMapper {



	public UserDTO member_Login(UserDTO dto);
	
	

	public List<UserDTO> AlluserList();

// =========================================
	public UserDTO oneUser_id(String u_id);
	public UserDTO user_email(String u_email);
// =========================================

	public UserDTO modify_pass(UserDTO dto);
	
// =========================================
	
	
	public int joinUser(UserDTO dto);

	public void deleteUser(UserDTO dto) throws Exception; //삭제


	public void modifyUser(UserDTO dto);
	
	public String findId(String u_email);
	
	public UserDTO selectMember(String u_email);
	
	public int update_pw(UserDTO dto);

	public UserDTO oneUser_email(UserDTO dto);
	
	
	// 디테일 불러오기 유저 + 어드민유저
	public UserDTO readMember(String u_id);
	public UserDTO adminReadUser(String u_id);
	// 끝


	// 소셜로그인관련
	public UserDTO social_Login(String u_email);
	public UserDTO searchEmail(String u_email);
	// 끝
}
