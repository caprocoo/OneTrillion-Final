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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.notice.Impl.NoticeService;
import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.often.impl.OftenService;
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

	@Autowired
	public NoticeService noticeService; // @@ 공지사항&자주하는질문 [10/11 월 한보영]
	@Autowired
	public OftenService oftenService;
	

// 회원가입 관련 페이지 ============================================================================================

	@RequestMapping(value = "/user/idCheckAjax.do", method = RequestMethod.GET)
	@ResponseBody
	public String idCheckAjax(@RequestParam("id") String id) {
		String result = "impossible";

		UserDTO user = service.oneUser_id(id);
		// DB에 ID값이 없으면
		if (user == null) {
			result = "possible";
		}
		return result;
	}

	// 이메일 중복확인
	@RequestMapping(value = "/user/emailCheckAjax.do", method = RequestMethod.GET)
	@ResponseBody
	public String emailCheckAjax(@RequestParam("email") String email) {
		String result = "impossible";

		UserDTO user = service.user_email(email);
		// DB에 ID값이 없으면
		if (user == null) {
			result = "possible";
		}
		return result;
	}

	// 3. 회원가입 페이지로 이동

//	@RequestMapping(value = "/user/joinagree.do", method = RequestMethod.GET)
//	public String joinAgreePage() {
//		return "user/joinagree";
//	}

	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String join_page(@ModelAttribute UserDTO dto) {
		// logger.info(">>>> user/join_page ");

		return "user/join";
	}

	// 4. 회원가입 실행
	@RequestMapping(value = "/user/join.do", method = RequestMethod.POST)
	public String join_action(@Valid UserDTO dto, BindingResult result) {
		if (result.hasErrors()) {
			logger.info(result.getAllErrors().get(0).getDefaultMessage());
			return "user/join";
		}

		try {
			userService.joinUser(dto);
			return "redirect:joinSucc.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 회원가입 성공 시 로그인 페이지로 이동~
		return "redirect:joinSucc.do";
	}

	// 회원가입 성공페이지 10-12 17:26 용상현
	@RequestMapping(value = "/user/joinSucc.do", method = RequestMethod.GET)
	public String joinSuccPage() {
		return "user/joinSucc";
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
	public ModelAndView login_action(@ModelAttribute UserDTO dto, HttpServletResponse resp) throws IOException {
		// logger.info(">>>> user/login_action");
		ModelAndView mav = new ModelAndView();
		mav = userService.member_Login(dto, resp);
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
	@RequestMapping(value = "/user/findId.do")
	public String findId() {
		return "user/findId";
	}

	// 아이디 찾기 실행
	@RequestMapping(value = "/user/findIdSucc.do", method = RequestMethod.POST)
	public ModelAndView findIdSucc(HttpServletResponse resp, @RequestParam(value = "u_email") String u_email)
			throws IOException {
		ModelAndView mav = new ModelAndView();

		mav = userService.findId(u_email, resp);
		return mav;
	}

	// ============================================================================================
	@RequestMapping(value = "/user/findPw", method = RequestMethod.GET)
	public ModelAndView findPw() {
		return new ModelAndView("/user/findPw");
	}

	@RequestMapping(value = "/user/findPw", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView findPwd(UserDTO dto, ModelAndView mav, HttpServletResponse resp) throws IOException {
		ModelAndView findpw = userService.findPw(dto, resp);
		resp.setCharacterEncoding("html/text; charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (findpw == null) {
			mav.setViewName("redirect:/user/findPw");
		} else {
			out.println("<script> alert('임시비밀번호를 전송하였습니다 가입하신 이메일을 확인해주세요');");
			out.println("location.href='http://localhost:8088/trip/user/login.do'</script>");
			out.close();
		}
		return mav;
	}

	// 회원정보 수정전 인증페이지
	@RequestMapping(value = "/user/modifyInfoPass", method = RequestMethod.GET)
	public String modifyInfoPassPage() {

		return "user/modifyInfoPass";
	}

	// 회원정보 수정전 인증페이지 POST
	@RequestMapping(value = "/user/modifyInfoPass", method = RequestMethod.POST)
	public ModelAndView modifyInfoPassPage_action(@ModelAttribute UserDTO dto, HttpServletResponse resp)
			throws IOException {
		ModelAndView mav = new ModelAndView();
		mav = userService.modify_pass(dto, resp);
		return mav;
	}

	@RequestMapping(value = "/user/modifyInfo.do", method = RequestMethod.GET)
	public String modify_page() {

		return "user/modifyInfo";
	}

	// 회원정보 수정 실행 메소드
	@RequestMapping(value = "/user/modifyInfo.do", method = RequestMethod.POST)
	public String modify_action(UserDTO member, String u_id, HttpSession session) {

		userService.modifyUser(member);

		session.removeAttribute("member");
		session.setAttribute("member", member);

		return "redirect:/user/myPageInfo.do?u_id=" + u_id;
	}

	@RequestMapping(value = "/user/myPageInfo.do", method = RequestMethod.GET)
	public String myPage_page(@RequestParam("u_id") String u_id, @ModelAttribute UserDTO dto, HttpServletRequest req) {
		// logger.info(">>>> user/myPage_page ");
		UserDTO userDto = userService.readMember(u_id);
		// System.out.println(userDto);
		req.setAttribute("userDto", userDto);
		return "user/myPageInfo";
	}

	@RequestMapping(value = "/user/deleteInfo.do", method = RequestMethod.GET)
	public void delete_page() throws Exception {
		logger.info(">>>> user/delete 들ㅇㅓ왔어 ㅎㅎㅎㅎ");
	}

	@RequestMapping(value = "/user/deleteInfo.do", method = RequestMethod.POST)
	public String delete_page(HttpSession session, UserDTO dto, RedirectAttributes rttr) throws Exception {
		logger.info(">>>> user/delete_page 이제 삭제 하면 돼,,,, ");
		UserDTO member = (UserDTO) session.getAttribute("member");

		userService.deleteUser(member);
		session.invalidate();

		return "redirect:../";
	}

	// 공지사항 & 자주하는 질문 목록으로 이동
	@RequestMapping(value = "/user/cs.do", method = RequestMethod.GET)
	public String cs_page(Model model) {
		// @@ 공지사항 목록 [10/11 월 한보영]
		List<CsnoticeDTO> noticeList = noticeService.selectAll();
		model.addAttribute("noticeList", noticeList);

		// @@ 자주하는 질문 목록 [10/11 월 한보영]
		List<OftenDTO> oftenList = oftenService.selectAll_often();
		model.addAttribute("oftenList", oftenList);

		return "user/cs";
	}
	@RequestMapping(value = "/user/contactUs.do", method = RequestMethod.GET)
	public String cs_contact_page(Model model) {
		return "user/contactUs";
	}

// 미구현 ============================================================================================	  



	@RequestMapping(value = "/user/reserveCheck.do", method = RequestMethod.GET)
	public String reserveCheck_page() {
		// logger.info(">>>> user/reserveCheck_page");
		return "user/reserveCheck";
	}

}
