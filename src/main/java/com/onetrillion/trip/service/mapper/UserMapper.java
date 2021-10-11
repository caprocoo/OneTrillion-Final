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


	public int joinUser(UserDTO dto);

	public void deleteUser(UserDTO dto) throws Exception; //삭제


	public void modifyUser(UserDTO dto);
	
	public String find_Id(String u_email);
	
	public UserDTO selectMember(String u_email);
	
	public int update_pw(UserDTO dto);

	public UserDTO oneUser_email(UserDTO dto);
	
	public UserDTO readMember(String u_id);

	
}
