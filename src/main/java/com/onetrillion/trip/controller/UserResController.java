package com.onetrillion.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.page.PageMaker;
import com.onetrillion.trip.userRes.UserResCriteria;
import com.onetrillion.trip.userRes.UserResDTO;
import com.onetrillion.trip.userRes.impl.UserResService;

@Controller
@RequestMapping(value = "/userRes")
public class UserResController {
	private static final Logger logger = LoggerFactory.getLogger(UserResController.class);
	
	@Autowired
	public UserResService service;
	
	
	//2021. 10. 12 15:30 현성 userReservation -회원 예약하기 아이디별로 전체 리스트 뽑기 구현
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String userSelectAll(Model model, HttpSession session){
		
		String u_id= (String) session.getAttribute("u_id");	
		List<UserResDTO> userResList = service.userSelectId(u_id);
		model.addAttribute("userResList", userResList);


		return "userRes/resList";
	}
	
	//2021. 10. 11 15:50 현성 userReservation - 회원 예약하기 insert 구현
	@RequestMapping(value = "/finished.do", method = RequestMethod.POST)
	@ResponseBody
	public String userResInsert(UserResDTO dto){
		
		service.userResInsert(dto);
		
		return "success";
	}
	
	//
	@RequestMapping(value = "/resDetail.do", method = RequestMethod.GET)
	public String userResDetail(int ures_seq, Model model){

		UserResDTO userResDetail = service.userResDetail(ures_seq);
		model.addAttribute("userResDetail", userResDetail);

		return "userRes/resDetail";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String userResDelete(int ures_seq){
		System.out.println(ures_seq);
		service.userResDelete(ures_seq);

		return "redirect:list.do";
	}
	
	
	@RequestMapping(value = "/listPage.do", method = RequestMethod.GET)
	public String userResListPage(Model model, UserResCriteria cri,HttpSession session){ 
		List<UserResDTO> userResList = service.userResPaging(cri);
		model.addAttribute("userResList", userResList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.userResCount());
		
		model.addAttribute("pageMaker", pageMaker);


		return "userRes/listPage";
	}
	
	
	
}
