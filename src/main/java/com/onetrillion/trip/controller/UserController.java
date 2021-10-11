package com.onetrillion.trip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.onetrillion.trip.user.UserDTO;
import com.onetrillion.trip.user.Impl.UserService;
import com.onetrillion.trip.user.Impl.UserServiceImpl;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserService userService;
	
	@Autowired
	public UserServiceImpl service;
	

// 회원가입 관련 페이지 ============================================================================================

	@RequestMapping(value="/user/idCheckAjax.do", method=RequestMethod.GET)
	@ResponseBody
	public String idCheckAjax(@RequestParam("id") String id) {
		String result = "impossible";
		
		UserDTO user = service.oneUser_id(id);
		// DB에 ID값이 없으면
		if(user == null) {
			result = "possible";
		}
		return result;
	}
	
	
	//이메일 중복확인
	@RequestMapping(value="/user/emailCheckAjax.do", method=RequestMethod.GET)
	@ResponseBody
	public String emailCheckAjax(@RequestParam("email") String email) {
		String result = "impossible";
		
		UserDTO user = service.user_email(email);
		// DB에 ID값이 없으면
		if(user == null) {
			result = "possible";
		}
		return result;
	}

	// 3. 회원가입 페이지로 이동

	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String join_page(@ModelAttribute UserDTO dto) {
		// logger.info(">>>> user/join_page ");

		return "user/join";
	}

	// 4. 회원가입 실행
	@RequestMapping(value = "/user/join.do", method = RequestMethod.POST)
	public String join_action(@Valid UserDTO dto, BindingResult result) {
		if(result.hasErrors()) {
			 logger.info(result.getAllErrors().get(0).getDefaultMessage());
			 return"user/join";
		}
		
		try {
			userService.joinUser(dto);
			return "redirect:login.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 회원가입 성공 시 로그인 페이지로 이동~
		return "redirect:login.do";
	}

// 로그인 관련 페이지 ============================================================================================

	// 5. 로그인 페이지로 이동
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String login_page() {
		// logger.info(">>>> user/login_page");
		return "user/login";
	}

	// 6. 로그인 정보 POST로 전송
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	   public ModelAndView login_action(@ModelAttribute UserDTO dto, HttpServletRequest req, HttpServletResponse resp) throws IOException {
	      //logger.info(">>>> user/login_action");
	      ModelAndView mav = new ModelAndView();
	      mav = userService.member_Login(dto,resp);
	      return mav;
	   }

//=========================================================================================================

	// 7. 로그아웃 처리
	// 0907 임시 로그아웃 0908 로그아웃 처리완료
	@RequestMapping(value = "/user/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "/user/login";
	}

// 아이디 찾기 ============================================================================================

	// 아이디 찾기 페이지로 이동
	@RequestMapping(value = "/user/findMyId.do")
	public String findMyId() {
		// logger.info(">>>> user/findMyId");
		return "user/findMyId";
	}

	// 아이디 찾기 실행
	@RequestMapping(value = "/user/find_id.do", method = RequestMethod.POST)
	public ModelAndView find_id(HttpServletResponse resp, @RequestParam(value = "u_email") String u_email) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		mav = userService.find_Id(u_email, resp);
		return mav;
	}
	

	// ============================================================================================
	@RequestMapping(value = "/user/pw-find", method = RequestMethod.GET)
	public ModelAndView findPw() {
		return new ModelAndView("/user/pw-find");
	}


	@RequestMapping(value = "/user/pw-find", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView findPwd(UserDTO dto, ModelAndView mav,HttpServletResponse resp) throws IOException {
		ModelAndView findpw = userService.findPw(dto,resp);
		resp.setCharacterEncoding("html/text; charset=utf-8");
		PrintWriter out = resp.getWriter();
		

		if(findpw == null) {
			mav.setViewName("redirect:/user/pw-find");
		} else {
			out.println("<script> alert('임시비밀번호를 전송하였습니다 가입하신 이메일을 확인해주세요');");
	        out.println("location.href='http://localhost:8088/trip/user/login.do'</script>");
	        out.close();
		}
		return mav;
	}
	
	
	// 회원정보 수정 페이지 이동
	@RequestMapping(value = "/user/modifyInfo", method = RequestMethod.GET)
	public String modify_page() {
		
		return "user/modifyInfo";
	}

	// 회원정보 수정 실행 메소드
	@RequestMapping(value = "/user/modifyInfo.do", method = RequestMethod.POST)
	public String modify_action(UserDTO member,String u_id,HttpSession session) {
		
		userService.modifyUser(member);
		
		session.removeAttribute("member");
		session.setAttribute("member", member);
		
		return "redirect:/user/myPage.do?u_id="+u_id;
	}


	@RequestMapping(value = "/user/myPage.do", method = RequestMethod.GET)
	public String myPage_page(@RequestParam("u_id") String u_id, @ModelAttribute UserDTO dto, HttpServletRequest req) {
		// logger.info(">>>> user/myPage_page ");
		UserDTO userDto = userService.readMember(u_id);
		//System.out.println(userDto);
		req.setAttribute("userDto", userDto);
		return "user/myPage";
	}



	@RequestMapping(value = "/user/delete.do", method = RequestMethod.GET)
	public void delete_page() throws Exception {
		logger.info(">>>> user/delete 들ㅇㅓ왔어 ㅎㅎㅎㅎ");
	}

	
	  @RequestMapping(value = "/user/delete.do", method = RequestMethod.POST)
	  public String delete_page(HttpSession session, UserDTO dto, RedirectAttributes rttr) throws Exception{ 
		   logger.info(">>>> user/delete_page 이제 삭제 하면 돼,,,, "); 
		  UserDTO member = (UserDTO) session.getAttribute("member"); 
		  
	  userService.deleteUser(member); 
	  session.invalidate();
	  
	  return "redirect:../"; 
	  }
	  
	// 미구현 ============================================================================================	  

	@RequestMapping(value = "/user/cs.do", method = RequestMethod.GET)
	public String cs_page() {
		// logger.info(">>>> user/cs_page");
		return "user/cs";
	}

	@RequestMapping(value = "/user/wishlist.do", method = RequestMethod.GET)
	public String wishlist_page() {
		// logger.info(">>>> user/wishlist_page");
		return "user/wishlist";
	}

	@RequestMapping(value = "/user/reserveCheck.do", method = RequestMethod.GET)
	public String reserveCheck_page() {
		// logger.info(">>>> user/reserveCheck_page");
		return "user/reserveCheck";
	}



}
