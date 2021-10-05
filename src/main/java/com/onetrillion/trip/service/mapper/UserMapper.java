package com.onetrillion.trip.service.mapper;

import java.util.List;


import com.onetrillion.trip.user.UserDTO;

public interface UserMapper {
	/*
	 * �ʿ��� ���!
	 * 1. ȸ������ 
	 * 2. �α��� 
	 * 3. ID / PW ã��
	 */
	// 0907
	public UserDTO member_Login(UserDTO dto);
	
	
	// ������ü����Ʈ (���θ� ���)
	public List<UserDTO> AlluserList();

	// �����Ѹ�ҷ����� PK - u_id
	public UserDTO oneUser_id(String u_id);

	// ����ȸ������
	public int joinUser(UserDTO dto);

	// ����ȸ��Ż��
	public void deleteUser(UserDTO dto) throws Exception; //삭제

	// ������������
	public int modifyUser(UserDTO dto);
	
	public String find_Id(String u_email);
	
	public UserDTO selectMember(String u_email);
	
	public int update_pw(UserDTO dto);

	public UserDTO oneUser_email(UserDTO dto);
	
	public UserDTO readMember(String u_id);

	
}
