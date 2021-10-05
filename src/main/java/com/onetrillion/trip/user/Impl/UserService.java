package com.onetrillion.trip.user.Impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.onetrillion.trip.user.UserDTO;



public interface UserService {

	public ModelAndView member_Login(UserDTO dto, HttpServletResponse resp) throws IOException;

	public List<UserDTO> AlluserList();

	public UserDTO oneUser_id(String u_id);

	public int joinUser(UserDTO dto);

	public void deleteUser(UserDTO dto) throws Exception;

	public int modifyUser(UserDTO dto);

	public String find_Id(String u_email);
	
	public UserDTO selectMember(String u_email);
	
	public int update_pw(UserDTO dto);
	public String findPw(UserDTO dto);
	public UserDTO oneUser_email(UserDTO dto);
	
	public UserDTO readMember(String u_id);
}
