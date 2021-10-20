package com.onetrillion.trip.user.Impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.onetrillion.trip.user.UserDTO;



public interface UserService {

	public ModelAndView member_Login(UserDTO dto, HttpServletResponse resp) throws IOException;

	public List<UserDTO> AlluserList();

	
	
// ==============================================
	
	public UserDTO oneUser_id(String u_id);
	public UserDTO user_email(String u_email);

// ==============================================	
	
	public ModelAndView modify_pass(UserDTO dto , HttpServletResponse resp) throws IOException;
	
// ==============================================	
	public int joinUser(UserDTO dto);

	public void deleteUser(UserDTO dto) throws Exception;

	public void modifyUser(UserDTO dto);

	public ModelAndView findId(String u_email, HttpServletResponse resp) throws IOException;
	
	public UserDTO selectMember(String u_email);
	
	public int update_pw(UserDTO dto);
	
	public ModelAndView findPw(UserDTO dto, HttpServletResponse resp) throws IOException;
	
	public UserDTO oneUser_email(UserDTO dto);
	
	// 회원디테일 , 어드민유저 디테일
	public UserDTO adminReadUser(String u_id);
	public UserDTO readMember(String u_id);
	// 끝

	public UserDTO social_Login(String u_email);

	public UserDTO searchEmail(String u_email);
}
