package com.onetrillion.trip.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onetrillion.trip.board.BoardCriteria;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.ImageDTO;
import com.onetrillion.trip.board.impl.BoardService;
import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.page.PageMaker;
import com.onetrillion.trip.userRes.UserResDTO;
import com.onetrillion.trip.userRes.impl.UserResService;
import com.onetrillion.trip.wishlist.WishlistDTO;
import com.onetrillion.trip.wishlist.impl.WishlistService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	int cnt = 1;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	public BoardService service;
	
	@Autowired
	public UserResService userResService;

	@Autowired
	public WishlistService wishService;
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(Model model) {
		List<BoardDTO> searchList = service.selectAll();
		model.addAttribute("searchList", searchList);
		return "board/search";
	}

	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) 
	public String detail(Model model, int pd_seq) {
		BoardDTO dto = service.detail(pd_seq);
		UserResDTO userDTO = userResService.userResDetail(pd_seq);
		WishlistDTO wDto = wishService.wishlistDetail(pd_seq); // 10/14 이희연 찜목록 구현 시 추가함
		System.out.println(userDTO);
		
		//1박 2일 구하기
		LocalDate start_date = dto.getPd_startDate();
		LocalDate last_date = dto.getPd_endDate();

		Period period = Period.between(start_date, last_date);
		Period period2 = period.plusDays(1);

		model.addAttribute("period", period.getDays()); // 6박
		model.addAttribute("period2", period2.getDays()); // 7일

		// 조회수 추가 
		dto.setPd_cnt(dto.getPd_cnt() + 1);
		service.cntUp(dto); // 조회수 증가

		ImageDTO image = service.detailImage(pd_seq);
		model.addAttribute("dto", dto);
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("image", image);
		model.addAttribute("wDto", wDto); // 10/14 이희연 찜목록 구현 시 추가함

		return "board/detail";
	}

	@RequestMapping(value = "/search.do", method = RequestMethod.POST)
	@ResponseBody
	public String searchData(@RequestParam Map<String, Object> map) {
		JSONArray dateSearch = new JSONArray();

		JSONObject searchList = new JSONObject();
		// 값을 header.jsp에서 String형으로 가져오기
		String sd = (String) map.get("startDate");
		String ed = (String) map.get("endDate");

		String loc = (String) map.get("location");
		// String kw = (String) map.get("keyword");
		if (sd == "" || ed == "") {
			sd = null;
			ed = null;
			searchList = new JSONObject();
			searchList.put("searchList", "");

			return searchList.toString();

		}

		else {
			// TIME

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
			LocalDate startDate = LocalDate.parse(sd, formatter);
			LocalDate endDate = LocalDate.parse(ed, formatter);

			List<BoardDTO> dataAll = service.selectAll();

			// pd_startDate, pd_endDate 중간 데이터 다 뽑아오기

			for (BoardDTO data : dataAll) {

				if (startDate.isEqual(data.getPd_startDate()) || endDate.isEqual(data.getPd_endDate())
						|| (!startDate.isEqual(data.getPd_startDate()) || !endDate.isEqual(data.getPd_endDate()))) {
					if (!startDate.isAfter(data.getPd_startDate()) && !endDate.isBefore(data.getPd_endDate())) {

						if (loc.equals(data.getPd_location())) {
							// && kw.equals(data.getPd_land())

							JSONObject dateJson = new JSONObject();

							dateJson.put("pd_seq", data.getPd_seq());
							dateJson.put("pd_name", data.getPd_name());
							dateJson.put("pd_theme", data.getPd_theme());
							dateJson.put("pd_price", data.getPd_price());
							dateJson.put("pd_image", data.getPd_image());
							dateJson.put("pd_startDate", data.getPd_startDate());
							dateJson.put("pd_endDate", data.getPd_endDate());

							dateSearch.put(dateJson);

						}

					}
				}

			}

			if (dateSearch.length() > 0) {
				searchList.put("searchList", dateSearch);
				// System.out.println(searchList);

			} else if (dateSearch.length() == 0) {
				searchList.put("searchList", "contentMiss");
			}
			return searchList.toString(2);
		}
	}
	
	//관리자 상품 수정 페이지 이동
	@RequestMapping(value = "modify.do", method = RequestMethod.GET)
	public String modifyGet(@RequestParam("pd_seq") int pd_seq, Model model) {
		BoardDTO dto = service.detail(pd_seq);
		model.addAttribute("dto", dto);
		return "board/modify";
	}
	//관리자 상품 수정 완료(Ajax)
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String modifyPost(@RequestParam("pd_seq") int pd_seq, Model model, BoardDTO dto) {
		model.addAttribute("pd_seq", pd_seq);
		service.modify(dto);
		return "redirect:detail.do";

	}
	//관리자가 상품 삭제 완료(Ajax)
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String deletePost(BoardDTO dto) {
		service.delete(dto);
		return "redirect:search.do";
	}
	
	//관리자 상품 입력 페이지 이동
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertGet() {
		
		return "board/insert";
	}
	
	//관리자 상품 입력 완료
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insertPost(BoardDTO dto) {
		System.out.println(dto);
		int cnt = service.insert(dto);
		if (cnt > 0) {
			return "redirect:search.do";
		}
		return "board/insert";
	}
	
	
	//회원 예약하기 페이지 이동
	@RequestMapping(value = "reservation.do", method = RequestMethod.GET)
	public String rsv_Get(@RequestParam("pd_seq") int pd_seq, Model model,
			@RequestParam("sel_adault") int sel_adault, // 성인
			@RequestParam("sel_young") int sel_young, // 18세 미만
			@RequestParam("sel_pet") int sel_pet, // 반려동물
			@RequestParam("total_price") int total_price, // 총 금액
			@RequestParam(value = "u_id") String u_id // 유저 아이디
	) {
		BoardDTO dto = service.detail(pd_seq); // seq에 대한 정보들 detail
		model.addAttribute("dto", dto);
		// 1박 2일 구하기
		LocalDate start_date = dto.getPd_startDate();
		LocalDate last_date = dto.getPd_endDate();
		Period period = Period.between(start_date, last_date);
		Period period2 = period.plusDays(1);
		model.addAttribute("period", period.getDays()); // 6박
		model.addAttribute("period2", period2.getDays()); // 7일
		// 원 단위
		DecimalFormat fomatter = new DecimalFormat("###,###,###");
		String total_price_won = fomatter.format(total_price); // 150000
		model.addAttribute("total_price_won", total_price_won); // 150,000
		// 총 인원 (명) - 아직 사용 안함
		int total = sel_adault + sel_young + sel_pet;
		model.addAttribute("total", total);
		

		return "board/reservation";
	}
	
	//예약하기 페이지 이동
	@RequestMapping(value = "noUserReservation.do", method = RequestMethod.GET)
	public String noUserRsv_Get(@RequestParam("pd_seq") int pd_seq, Model model,
			@RequestParam("sel_adault") int sel_adault, // 성인
			@RequestParam("sel_young") int sel_young, // 18세 미만
			@RequestParam("sel_pet") int sel_pet, // 반려동물
			@RequestParam("total_price") int total_price // 총 금액
	) {
		BoardDTO dto = service.detail(pd_seq); // seq에 대한 정보들 detail
		model.addAttribute("dto", dto);
		// 1박 2일 구하기
		LocalDate start_date = dto.getPd_startDate();
		LocalDate last_date = dto.getPd_endDate();
		Period period = Period.between(start_date, last_date);
		Period period2 = period.plusDays(1);
		model.addAttribute("period", period.getDays()); // 6박
		model.addAttribute("period2", period2.getDays()); // 7일
		// 원 단위
		DecimalFormat fomatter = new DecimalFormat("###,###,###");
		String total_price_won = fomatter.format(total_price); // 150000
		model.addAttribute("total_price_won", total_price_won); // 150,000
		// 총 인원 (명) - 아직 사용 안함
		int total = sel_adault + sel_young + sel_pet;
		model.addAttribute("total", total);
		

		return "board/noUserReservation";
	}
	
	
	//확인필요!!
	@RequestMapping(value = "reservation.do", method = RequestMethod.POST)
	public String rsv_Post(@RequestParam("pd_seq") int pd_seq, @RequestParam(value = "u_id") String u_id, Model model,
			BoardDTO dto) {
		model.addAttribute("pd_seq", pd_seq);
		service.detail(pd_seq);

		return "redirect:success.do";

	}
	
	//결제 완료 페이지 이동
	@RequestMapping(value = "/success.do", method = RequestMethod.GET)
	public String successGet(@RequestParam("pd_seq") int pd_seq, @RequestParam(value = "u_id") String u_id,
			Model model) {
		BoardDTO dto = service.detail(pd_seq); // seq에 대한 정보들 detail
		model.addAttribute("pd_seq", pd_seq);
		model.addAttribute("dto", dto);
		return "board/success";
	}
	
	//테마 더보기 클릭시 페이지 이동
	@RequestMapping(value = "/searchTheme.do", method = RequestMethod.GET)
	public String searchTheme(@RequestParam("pd_theme") String pd_theme, Model model) {
		// System.out.println(pd_theme);
		List<BoardDTO> searchThemeList = service.theme(pd_theme);
		model.addAttribute("searchThemeList", searchThemeList);
		// System.out.println(searchThemeList);

		return "board/searchList";
	}

	@RequestMapping(value = "/perinfo.do", method = RequestMethod.GET)
	public String personalInfo() {

		return "compony/perinfo";
	}

	@RequestMapping(value = "/agreeFoot.do", method = RequestMethod.GET)
	public String agreefoot() {

		return "compony/agreeFoot";
	}

	@RequestMapping(value = "/tripAgreeFoot.do", method = RequestMethod.GET)
	public String tripAgreeFoot() {

		return "compony/tripAgreeFoot";
	}

	@RequestMapping(value = "/introduce.do", method = RequestMethod.GET)
	public String introduce() {

		return "compony/introduce";
	}
	
	@RequestMapping(value = "/listPage.do", method = RequestMethod.GET)
	public String listPage(BoardCriteria cri, Model model) {
		
		List<BoardDTO> list = service.BoardPaging(cri);
		model.addAttribute("list", list);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.BoardCount());
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/listPage";
	}

}
