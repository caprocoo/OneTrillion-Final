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

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.ImageDTO;
import com.onetrillion.trip.board.impl.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	int cnt = 1;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	public BoardService service;

	@RequestMapping(value = "/mainPage.do", method = RequestMethod.GET)
	public String mainPage(Model model) {

		List<BoardDTO> aloneList = service.theme("alone");
		List<BoardDTO> familyList = service.theme("family");
		List<BoardDTO> coupleList = service.theme("couple");
		List<BoardDTO> petList = service.theme("pet");
		List<BoardDTO> honeymoonList = service.theme("honeymoon");
		List<BoardDTO> friendList = service.theme("friend");

		model.addAttribute("aloneList", aloneList);
		model.addAttribute("familyList", familyList);
		model.addAttribute("coupleList", coupleList);
		model.addAttribute("petList", petList);
		model.addAttribute("honeymoonList", honeymoonList);
		model.addAttribute("friendList", friendList);

		return "board/mainPage";
	}

	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(Model model) {
		List<BoardDTO> searchList = service.selectAll();
		model.addAttribute("searchList", searchList);

		// System.out.println(searchList);
		return "board/search";
	}

	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) //// ========================================추가
	//// 9/11
	public String detail(Model model, int pd_seq, String u_id, HttpServletRequest request) {
		BoardDTO dto = service.detail(pd_seq);
//System.out.println(divList);

//1박 2일 구하기
		LocalDate start_date = dto.getPd_startDate();
		LocalDate last_date = dto.getPd_endDate();
//		System.out.println(start_date);
//		System.out.println(last_date);
		
		Period period = Period.between(start_date, last_date);
		Period period2 = period.plusDays(1);
//		System.out.println(period.getDays());
//		System.out.println(period2.getDays());

		model.addAttribute("period", period.getDays()); // 6박
		model.addAttribute("period2", period2.getDays()); // 7일

// 조회수 추가 9/10
		dto.setPd_cnt(dto.getPd_cnt() + 1);
		service.cntUp(dto); // 조회수 증가

//디테일 이미지 5개
		ImageDTO image = service.detailImage(pd_seq);
		model.addAttribute("dto", dto);
		model.addAttribute("image", image);

		return "board/detail";
	}

	@RequestMapping(value = "/search.do", method = RequestMethod.POST)
	@ResponseBody
	public String searchData(@RequestParam Map<String, Object> map, Model model) {
		JSONArray dateSearch = new JSONArray();

		JSONObject searchList = new JSONObject();
		// 값을 header.jsp에서 String형으로 가져오기
		String sd = (String) map.get("startDate");
		String ed = (String) map.get("endDate");

		String nt = (String) map.get("nation");
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

//		System.out.println(startDate);
//		System.out.println(endDate);
//		System.out.println(startDate.getClass().getName());

			// BoardDTO dto = service.detail(84);
//		System.out.println(dto.getPd_startDate());// 관련된 dto toString() 출력
//		System.out.println(dto.getPd_endDate());
//		System.out.println(dto.getPd_startDate().isBefore(startDate));
//		System.out.println(dto.getPd_endDate().isAfter(endDate));

			List<BoardDTO> dataAll = service.selectAll();

			// System.out.println(dto.getPd_startDate().getClass().getName());
			// System.out.println(!dto.getPd_startDate().equals(startDate)); // true
			// System.out.println(!dto.getPd_endDate().equals(endDate)); // true

			// pd_startDate, pd_endDate 중간 데이터 다 뽑아오기

			for (BoardDTO data : dataAll) {

				if (startDate.isEqual(data.getPd_startDate()) || endDate.isEqual(data.getPd_endDate())
						|| (!startDate.isEqual(data.getPd_startDate()) || !endDate.isEqual(data.getPd_endDate()))
				// || !startDate.isEqual(data.getPd_startDate()) ||
				// !endDate.isEqual(data.getPd_endDate())
				) {
					if (!startDate.isAfter(data.getPd_startDate()) && !endDate.isBefore(data.getPd_endDate())) {

						if (nt.equals(data.getPd_nation()) && loc.equals(data.getPd_location())) {
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

//				else if (!startDate.isEqual(data.getPd_startDate()) || !endDate.isEqual(data.getPd_endDate())) {
//					if (data.getPd_startDate().isBefore(startDate) || endDate.isAfter(data.getPd_endDate())) {
//						// System.out.println("2 >> startDate >>> "+data.getPd_startDate());
//						// System.out.println("2 >> endDate >>> "+data.getPd_endDate());
//						if (nt.equals(data.getPd_nation()) && loc.equals(data.getPd_location()) && kw.equals(data.getPd_land())) {
//							JSONObject dateJson = new JSONObject();
//							dateJson.put("pd_seq", data.getPd_seq());
//							dateJson.put("pd_name", data.getPd_name());
//							dateJson.put("pd_theme", data.getPd_theme());
//							dateJson.put("pd_price", data.getPd_price());
//							dateJson.put("pd_image", data.getPd_image());
//							dateJson.put("pd_startDate", data.getPd_startDate());
//							dateJson.put("pd_endDate", data.getPd_endDate());
//							dateSearch.put(dateJson);
//							istrue = true;
//						}else {
//							istrue = false;
//						}
//
//					}
//				}

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

	@RequestMapping(value = "modify.do", method = RequestMethod.GET)
	public String modifyGet(@RequestParam("pd_seq") int pd_seq, Model model, RedirectAttributes re) {
		re.addAttribute("pd_seq", pd_seq);
		BoardDTO dto = service.detail(pd_seq);
		model.addAttribute("dto", dto);
		return "board/modify";
	}

	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String modifyPost(@RequestParam("pd_seq") int pd_seq, Model model, BoardDTO dto) {
		model.addAttribute("pd_seq", pd_seq);
		service.modify(dto);
		return "redirect:detail.do";

	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String deletePost(Model model, BoardDTO dto) {
		service.delete(dto);
		return "redirect:search.do";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertGet() {
		return "board/insert";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insertPost(BoardDTO dto) {
		int cnt = service.insert(dto);
		if (cnt > 0) {
			return "redirect:search.do";
		}
		return "board/insert";
	}

	@RequestMapping(value = "reservation.do", method = RequestMethod.GET)
	public String rsv_Get(@RequestParam("pd_seq") int pd_seq, Model model, RedirectAttributes re,
			@RequestParam("sel_adault") int sel_adault, // 성인
			@RequestParam("sel_young") int sel_young, // 18세 미만
			@RequestParam("sel_pet") int sel_pet, // 반려동물
			@RequestParam("total_price") int total_price, // 총 금액
			@RequestParam(value = "u_id") String u_id // 유저 아이디
	) {
		re.addAttribute("pd_seq", pd_seq);
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
		// 총 인원 (명)
		int total = sel_adault + sel_young + sel_pet;
		model.addAttribute("total", total);

		return "board/reservation";
	}

	@RequestMapping(value = "reservation.do", method = RequestMethod.POST)
	public String rsv_Post(@RequestParam("pd_seq") int pd_seq, @RequestParam(value = "u_id") String u_id, Model model,
			BoardDTO dto) {
		model.addAttribute("pd_seq", pd_seq);
		service.detail(pd_seq);

		return "redirect:success.do";

	}

	@RequestMapping(value = "/success.do", method = RequestMethod.GET)
	public String successGet(@RequestParam("pd_seq") int pd_seq, @RequestParam(value = "u_id") String u_id,
			Model model) {
		BoardDTO dto = service.detail(pd_seq); // seq에 대한 정보들 detail
		model.addAttribute("pd_seq", pd_seq);
		model.addAttribute("dto", dto);
		return "board/success";
	}

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

		return "board/perinfo";
	}

	@RequestMapping(value = "/agreeFoot.do", method = RequestMethod.GET)
	public String agreefoot() {

		return "board/agreeFoot";
	}

	@RequestMapping(value = "/tripAgreeFoot.do", method = RequestMethod.GET)
	public String tripAgreeFoot() {

		return "board/tripAgreeFoot";
	}
	@RequestMapping(value = "/introduce.do", method = RequestMethod.GET)
	public String introduce() {

		return "board/introduce";
	}

}
