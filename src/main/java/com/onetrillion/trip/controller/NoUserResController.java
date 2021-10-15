package com.onetrillion.trip.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.noUserRes.NoUserResCriteria;
import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.noUserRes.impl.NoUserResService;
import com.onetrillion.trip.page.PageMaker;
import com.onetrillion.trip.userRes.UserResCriteria;
import com.onetrillion.trip.userRes.UserResDTO;

@Controller
@RequestMapping(value = "/noUserRes")
public class NoUserResController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoUserResController.class);
	
	@Autowired
	public NoUserResService service;
	
	//2021. 10. 11 19:35 현성 noUserReservation -비회원 예약 전체 리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String noUserSelectAll(Model model){
		
		List<NoUserResDTO> noUserResList = service.noUserSelectAll();
		model.addAttribute("noUserResList", noUserResList);
		
		return "noUserRes/list";
	}
	
	//2021. 10. 12 17:30 현성 noUserReservation -비회원 상세예약확인 페이지
	@RequestMapping(value = "/selectId.do", method = RequestMethod.GET)
	public String noUserSelectId(Model model, String res_email){
		
		NoUserResDTO noUserSelectId = service.noUserSelectId(res_email);
		model.addAttribute("noUserSelectId", noUserSelectId);
		
		return "noUserRes/resDetNoMem";
	}
	
	//2021. 10. 11 19:35 현성 noUserReservation -비회원 예약 insert 구현
	@RequestMapping(value = "/finished.do", method = RequestMethod.POST)
	@ResponseBody
	public String noUserResInsert(NoUserResDTO dto){
		//System.out.println(dto);
		service.noUserResInsert(dto);
		return null;
	}
	
	//2021.10.12 11:00 현성 noUserReservation -비회원 예약 조회 로그인 페이지로 이동
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String noUserCheck(){
		return "noUserRes/resDetNoMemLog";
	}
	
	//2021.10.12 17:00 현성비회원 예약조회관련 이메일 및 비밀번호 값 불러오기(Ajax)
	@RequestMapping(value = "/resDetail.do", method = RequestMethod.POST)
	@ResponseBody
	public String resDetail(@RequestParam("res_email") String res_email, @RequestParam("res_pwd")String res_pwd, Model model){
		//System.out.println(res_email);
		//System.out.println(res_pwd);
		NoUserResDTO dto = service.noUserDetail(res_email, res_pwd);
		if(dto==null) {
			return "안녕";
		}else {
			model.addAttribute("noUserEmailPwd", dto);
		}
		
		return null;
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String noUserDelete( Model model, int res_seq){
		System.out.println(res_seq);
		service.noUserResDelete(res_seq);

		return "noUserRes/listPage";
	}
	
	
	@RequestMapping(value = "/listPage.do", method = RequestMethod.GET)
	public String noUserResListPage(Model model, NoUserResCriteria cri){
		
		List<NoUserResDTO> noUserResList = service.noUserResPaging(cri);
		model.addAttribute("noUserResList", noUserResList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.noUserResCount());
		
		model.addAttribute("pageMaker", pageMaker);


		return "noUserRes/listPage";
	}

	
	
}
