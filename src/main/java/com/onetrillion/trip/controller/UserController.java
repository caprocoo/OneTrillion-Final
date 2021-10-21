package com.onetrillion.trip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;
import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.notice.Impl.NoticeService;
import com.onetrillion.trip.oauth.GoogleOAuthRequest;
import com.onetrillion.trip.oauth.GoogleOAuthResponse;
import com.onetrillion.trip.oauth.NaverLogin;
import com.onetrillion.trip.oauth.NaverValue;
import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.often.impl.OftenService;
import com.onetrillion.trip.user.UserDTO;
import com.onetrillion.trip.user.Impl.UserService;
import com.onetrillion.trip.user.Impl.UserServiceImpl;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	public final static String GOOGLE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
	public final static String CLIENT_ID = "391287285732-4c7pd72fh1ir9af9llc4tmoas2as4qog.apps.googleusercontent.com";
	public final static String CLIENT_SECRET = "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";

	@Autowired
	public UserService userService;

	@Autowired
	public UserServiceImpl service;

	@Autowired
	public NoticeService noticeService; // @@ 공지사항&자주하는질문 [10/11 월 한보영]
	@Autowired
	public OftenService oftenService;

	@Autowired
	public BoardService boardService;
	
	@Inject
	private NaverValue naverSns;
	


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
	public String login_page(Model model) {
		
		NaverLogin NaverLogin = new NaverLogin(naverSns);
		model.addAttribute("naver_url", NaverLogin.getNaverAuthURL());
		
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

//	http://localhost:8088/trip/user/oauthcallback
	@GetMapping("/user/oauthcallback")
	public String googleAuth(Model model, @RequestParam(value = "code") String authCode, UserDTO user,
			HttpSession session, HttpServletResponse resp) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		

		// 토큰요청을 위한 파라미터 세팅
		GoogleOAuthRequest googleOAuthRequestParam = GoogleOAuthRequest.builder().clientId(CLIENT_ID)
				.clientSecret(CLIENT_SECRET).code(authCode).redirectUri("http://localhost:8088/trip/user/oauthcallback")
				.grantType("authorization_code").build();

		// Json 파싱 시작 
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.setSerializationInclusion(Include.NON_NULL);

		// 엑세스 토큰 발급요청
		ResponseEntity<String> resultEntity = restTemplate.postForEntity(GOOGLE_TOKEN_BASE_URL, googleOAuthRequestParam,
				String.class);

		// 토큰리스퐌스
		GoogleOAuthResponse result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponse>() {
		});

		// ID Token만 추출
		String jwtToken = result.getIdToken();
		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
				.queryParam("id_token", jwtToken).toUriString();

		String resultJson = restTemplate.getForObject(requestUrl, String.class);

		Map<String, String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>() {
		});

		String userEmail = userInfo.get("email"); // 구글에서 받아온 이메일값
		
		UserDTO dto = userService.searchEmail(userEmail); // SQL문에 이메일넣어서 함
		// 컨펌
		
		System.out.println(userEmail);
		if (dto == null) {
			model.addAttribute("userEmail",userEmail);
			model.addAttribute("token", result.getAccessToken());
			return "user/join";
		} else {
			UserDTO member = userService.social_Login(userEmail);
			model.addAttribute("member", member);
			session.setAttribute("member", member);
			session.setAttribute("u_id", member.getU_id());
			session.setMaxInactiveInterval(-1);
			ModelAndView mav = new ModelAndView();
			mav.setViewName(userEmail);

			List<BoardDTO> aloneList = boardService.theme("alone");
			List<BoardDTO> familyList = boardService.theme("family");
			List<BoardDTO> coupleList = boardService.theme("couple");
			List<BoardDTO> petList = boardService.theme("pet");
			List<BoardDTO> honeymoonList = boardService.theme("honeymoon");
			List<BoardDTO> friendList = boardService.theme("friend");

			model.addAttribute("aloneList", aloneList);
			model.addAttribute("familyList", familyList);
			model.addAttribute("coupleList", coupleList);
			model.addAttribute("petList", petList);
			model.addAttribute("honeymoonList", honeymoonList);
			model.addAttribute("friendList", friendList);

			return "/board/mainPage";

		}
		// 로그인후 메인페이지로~ ( 해야되는것
		// 1. 받아온 데이터 파싱된거 필요한 값을 뿌리기
		// 2. 로그인처리 ( 가입여부 확인해서 로그인 회원가입 분기 )
		// 3. 세션부여
		// 4. 행복사
	}
	
	@RequestMapping(value="/user/naveroauthcallback", method =  {RequestMethod.GET,RequestMethod.POST})
	public String NaverLoginCallback(Model model, @RequestParam String code, HttpSession session) throws Exception {
		NaverLogin naverlogin = new NaverLogin(naverSns);
		UserDTO profile = naverlogin.getUserProfile(code);
		
		String userEmail = profile.getU_email();
		System.out.println(userEmail);
		UserDTO dto = userService.searchEmail(userEmail);
		if(dto == null) {
			model.addAttribute("userEmail" , userEmail);
			return "user/join";
		} else {
			UserDTO member = userService.social_Login(userEmail);
			session.setAttribute("member", member);
			session.setAttribute("u_id", member.getU_id());
			session.setMaxInactiveInterval(-1);
			List<BoardDTO> aloneList = boardService.theme("alone");
			List<BoardDTO> familyList = boardService.theme("family");
			List<BoardDTO> coupleList = boardService.theme("couple");
			List<BoardDTO> petList = boardService.theme("pet");
			List<BoardDTO> honeymoonList = boardService.theme("honeymoon");
			List<BoardDTO> friendList = boardService.theme("friend");

			model.addAttribute("aloneList", aloneList);
			model.addAttribute("familyList", familyList);
			model.addAttribute("coupleList", coupleList);
			model.addAttribute("petList", petList);
			model.addAttribute("honeymoonList", honeymoonList);
			model.addAttribute("friendList", friendList);
			return "/board/mainPage";
		}
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

	// 자주하는 질문
	@RequestMapping(value = "/user/csOften.do", method = RequestMethod.GET)
	public String cs_page(Model model) {
		// @@ 자주하는 질문 목록 [10/11 월 한보영]
		List<OftenDTO> oftenList = oftenService.selectAll_often();
		model.addAttribute("oftenList", oftenList);

		return "user/csOften";
	}

	// 공지사항
	@RequestMapping(value = "/user/cs.do", method = RequestMethod.GET)
	public String cs_page_notice(Model model) {
		// @@ 공지사항 목록 [10/11 월 한보영]
		List<CsnoticeDTO> noticeList = noticeService.selectAll();
		model.addAttribute("noticeList", noticeList);

		return "user/csNotice";
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
	
	
//	@GetMapping("/user/naveroauthcallback")
//	public String naveroauthcallback(Model model, @RequestParam(value = "code") String code, UserDTO user)
//			throws JsonMappingException, JsonProcessingException {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
//			public boolean hasError(ClientHttpResponse response) throws IOException {
//				HttpStatus statusCode = response.getStatusCode();
//				return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
//			}
//		});
//
//		NaverOAuthRequest naverOauthRequest = NaverOAuthRequest.builder().client_id(NAVERCLIENT_ID)
//				.client_secret(NAVERCLIENT_SECRET).redirectUri("http://localhost:8088/trip/user/naveroauthcallback")
//				.code(code).grant_type("authorization_code").build();
//
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//		mapper.setSerializationInclusion(Include.NON_NULL);
//
//		ResponseEntity<String> resultEntity = restTemplate.postForEntity(NAVER_TOKEN_BASE_URL, naverOauthRequest,
//				String.class);
//
//		NaverOAuthResponse result = mapper.readValue(resultEntity.getBody(), new TypeReference<NaverOAuthResponse>() {
//		});
//
//		// 추출
//
////		String jwtToken = result.getIdToken();
////		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
////				.queryParam("id_token", jwtToken).toUriString();
////
////		String resultJson = restTemplate.getForObject(requestUrl, String.class);
////
////		Map<String, String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>() {
////		});
////
////		String userEmail = userInfo.get("email"); // 구글에서 받아온 이메일값
//
//		String Token = result.getAccess_token();
//		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://openapi.naver.com/v1/nid/me")
//				.queryParam("Token", Token).toUriString();
//
//		String resultJson = restTemplate.getForObject(requestUrl, String.class);
//
//		Map<String, String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>() {
//		});
//
////		String userEmail = userInfo.get("email");
////		
////		UserDTO dto = userService.searchEmail(userEmail);
//
//		model.addAttribute("userInfo", userInfo);
//		return "/board/mainPage";
//	}

}
