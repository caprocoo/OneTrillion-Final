package com.onetrillion.trip.user.Impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.onetrillion.trip.service.mail.MailUtil;
import com.onetrillion.trip.service.mapper.UserMapper;
import com.onetrillion.trip.user.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserMapper mapper;
	@Autowired
	public HttpSession session;
	
	
	
	@Override
	public List<UserDTO> AlluserList(){
		return mapper.AlluserList();
	}

	// ==============================================
	@Override
	public UserDTO oneUser_id(String u_id) {
		//System.out.println("::::: oneUser ::::::");
		UserDTO user = mapper.oneUser_id(u_id);
		//System.out.println(user);
		return user;
	}
	
	@Override
	public UserDTO user_email(String u_email) {
		
		UserDTO user = mapper.user_email(u_email);
		
		return user;
		
	}
	// ==============================================
	
	@Override
	public UserDTO oneUser_email(UserDTO dto) {

		return mapper.oneUser_email(dto);
	}

	@Override
	public int joinUser(UserDTO dto) {
		return mapper.joinUser(dto);
	}

	@Override
	public void deleteUser(UserDTO dto) throws Exception {
		mapper.deleteUser(dto);
	}

	@Override
	public void modifyUser(UserDTO dto) {		
		mapper.modifyUser(dto);
	}
	

	@Override 
	   public ModelAndView member_Login(UserDTO dto,HttpServletResponse resp) throws IOException {
	      ModelAndView mav = new ModelAndView();
	      resp.setContentType("text/html; charset=utf-8");
	      PrintWriter out = resp.getWriter();
	      UserDTO member = mapper.member_Login(dto);

	      if (member != null) {
	         session.setAttribute("u_id", dto.getU_id());
	         session.setAttribute("member", member);
	         mav.addObject("member", member);

	         mav.setViewName("redirect:../");

	         session.setMaxInactiveInterval(-1);

	      } else {
	         out.println("<script> alert('아이디 또는 비밀번호를 다시 확인해주세요');");
	         out.println("history.go(-1);</script>");
	         out.close();
	         
	      }
	      return mav;
	   }

	@Override
	public UserDTO selectMember(String u_email) {

		return mapper.selectMember(u_email);
	}



	@Override
	public ModelAndView findId(String u_email,HttpServletResponse resp) throws IOException {
		ModelAndView mav = new ModelAndView();
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		String email = mapper.findId(u_email);
		
		if(email != null) {
			mav.addObject("u_email",email);
			mav.setViewName("user/findIdSucc");
		} else {
			out.println("<script> alert('이메일을 다시 확인해주세요');");
	        out.println("history.go(-1);</script>");
	        out.close();
		}
		return mav;
	}
	
	
	// 메일로 비밀번호찾기
	@Override
	public ModelAndView findPw(UserDTO dto, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		ModelAndView mav = new ModelAndView();
		resp.setContentType("text/html; charset=utf-8");
		
		// 회원정보 불러오기
		UserDTO user = mapper.oneUser_email(dto);

		// 가입된 이메일이 존재한다면 이메일 발송
		if (user != null) {
			// 임시비밀번호 생성 UUID를 사용 * 특수문자는 못넣는다!
			String tempPw = UUID.randomUUID().toString().replace("-", ""); // -를 제거
			tempPw = tempPw.substring(0, 10); // tempPw를 우리 비밀번호 범위에 맞춰서 나오게 서브스트링으로 앞에서 10번째까지 짜름

			// user객체에 임시 비밀번호 담기
			user.setU_pwd(tempPw);

			// 메일전송
			MailUtil mail = new MailUtil();
			mail.sendMail(user);

			mapper.update_pw(user);
			
		} else {
			out.println("<script> alert('이메일을 다시 확인해주세요');");
	        out.println("history.go(-1);</script>");
	        out.close();
		}
		return mav;
	}
	
	@Override
	public int update_pw(UserDTO dto) {
		return mapper.update_pw(dto);
	}
	// 메일로 비밀번호찾기
	
	
	@Override // 회원정보보기
	public UserDTO readMember(String u_id) {
		UserDTO dto = null;

		try {
			mapper.readMember(u_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
