package com.onetrillion.trip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import org.springframework.validation.ObjectError;
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

// 회원가입 관련 페이지 ============================================================================================

//	// 1. 아이디 중복검사 페이지 이동
//	@RequestMapping(value = "/user/idCheck.do", method = RequestMethod.GET)
//	public String idCheck_page(@ModelAttribute UserDTO dto) {
//		logger.info(">>>> 들어왔단다");
//		
//		
//		userService.oneUser(dto.getU_id());
//		if ((dto.getU_pwd()) == null) {
//			System.out.println("아이디가 존재하지 않아유 >> 회원가입 가능!");
//			return "user/join";
//		} else {
//			System.out.println("아이디가 존재해유 >> 회원가입 불가ㅠ_ㅠ");
//			return null;
//		}
//	}
//
//	// 2. 아이디 중복검사 실행 (일단 넣어놔쓰,,,)
//	@RequestMapping(value = "/user/idCheck.do", method = RequestMethod.POST)
//	public String idCheck_action(@ModelAttribute UserDTO dto) {
//		logger.info(">>>> user/idCheck ");
//		return "redirect:join.do";
//	}

	// 3. 회원가입 페이지로 이동

	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String join_page(@ModelAttribute UserDTO dto) {
		// logger.info(">>>> user/join_page ");

		return "user/join";
	}

	// 4. 회원가입 실행
	@RequestMapping(value = "/user/join.do", method = RequestMethod.POST)
	public String join_action(@Valid UserDTO dto, BindingResult result) {
		// BindingResult는 검증결과에 대한 결과정보를 받음 즉 컨트롤러에서 뷰이름을 반환하면 에러내용을 바인딩해서 JSP에 넘겨줄테니 값을
		// 사용자에게 보여주라는 의미의 포워딩 개념이깔려있다

		// logger.info(">>>> user/join_action");
		// 에러가 생기면(hasErrors)를 ObjectError list에 담아서 쏴주고 리턴
		if (result.hasErrors()) {

			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error);
			}
			return "user/join";
		}

		userService.joinUser(dto);
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
	public String find_id(HttpServletResponse resp, @RequestParam(value = "u_email") String u_email, Model model) {

		model.addAttribute("id", userService.find_Id(u_email));
		return "user/find_id";
	}

	// ============================================================================================
	@RequestMapping(value = "/user/pw-find", method = RequestMethod.GET)
	public ModelAndView findPw() {
		return new ModelAndView("/user/pw-find");
	}

	// Mav로 받아서 쏴주니까 된당 ㅋ
	@RequestMapping(value = "/user/pw-find", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView findPwd(UserDTO dto, ModelAndView mav) { // 모델앤뷰?
		String findpw = userService.findPw(dto);
		//System.out.println("폼에서 받아온 이메일값 체크" + dto);
		mav.addObject("findpw", findpw);

		if (findpw == null || findpw == "") {
			mav.setViewName("redirect:/user/pw-find");
		} else {
			mav.setViewName("/user/pw-find");
		}
		return mav;
	}

// 미구현 ============================================================================================
	@RequestMapping(value = "/user/myPage.do", method = RequestMethod.GET)
	public String myPage_page(@RequestParam("u_id") String u_id, @ModelAttribute UserDTO dto, HttpServletRequest req) {
		// logger.info(">>>> user/myPage_page ");
		UserDTO userDto = userService.readMember(u_id);
		//System.out.println(userDto);
		req.setAttribute("userDto", userDto);
		return "user/myPage";
	}

	@RequestMapping(value = "/user/myPage.do", method = RequestMethod.POST)
	public String myPage_page_Post(@RequestParam("u_id") String u_id, @ModelAttribute UserDTO dto,
			HttpServletRequest req) {
		// logger.info(">>> user/myPage_page_Post");

		userService.modifyUser(dto);
		req.setAttribute("dto", dto);
		req.setAttribute("u_id", u_id);
		return "redirect:/user/myPage.do";
	}

	@RequestMapping(value = "/user/delete.do", method = RequestMethod.GET)
	public void delete_page() throws Exception {
		logger.info(">>>> user/delete 들ㅇㅓ왔어 ㅎㅎㅎㅎ");
	}

	
	  @RequestMapping(value = "/user/delete.do", method = RequestMethod.POST)
	  public String delete_page(HttpSession session, UserDTO dto, RedirectAttributes rttr) throws Exception{ 
		   logger.info(">>>> user/delete_page 이제 삭제 하면 돼,,,, "); 
		  UserDTO member = (UserDTO) session.getAttribute("member"); 
		  //String oldPwd = member.getU_pwd(); 
		 //String newPwd = dto.getU_pwd();

	  userService.deleteUser(member); 
	  session.invalidate();
	  
	  return "redirect:../board/mainPage.do"; 
	  }

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

	// 회원정보 수정 페이지 이동
	@RequestMapping(value = "/user/modify.do", method = RequestMethod.GET)
	public String modify_page(@RequestParam("u_id") String u_id, @ModelAttribute UserDTO dto, HttpServletRequest req) {
		// logger.info(">>> user/modify");
		UserDTO userDto = userService.readMember(u_id);
		req.setAttribute("userDto", userDto);

		return "user/modify";
	}

	// 회원정보 수정 실행 메소드
	@RequestMapping(value = "/user/modify.do", method = RequestMethod.POST)
	public String modify_action(@RequestParam("u_id") String u_id, @ModelAttribute UserDTO dto,
			HttpServletRequest req) {
		// logger.info(">>> user/modify");

		userService.modifyUser(dto);
		req.setAttribute("dto", dto);
		req.setAttribute("u_id", u_id);
		return "redirect:/user/myPage.do";
	}

}
