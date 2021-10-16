package com.onetrillion.trip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.notice.Impl.NoticeService;
import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.often.impl.OftenService;


@Controller
@RequestMapping(value = "/adminOften") //==10/16 자주묻는질문 한보영
public class AdminOftenController {
	
	@Autowired
	public OftenService oftenService; // @@ 공지사항&자주하는질문 
	
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String adminOften(Model model) {
		List<OftenDTO> oftenList = oftenService.selectAll_often();
		model.addAttribute("oftenList", oftenList);		
		
		return "adminOften/adminOften";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String often_input() {
		return "adminOften/adminOftenInput";
	}
	//수정
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String often_modify() {
		return "adminOften/adminOftenModi";
	}
	//삭제
//	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
//	public String often_delete() {
//		return "adminOften/adminOften";
//	}

	

//	@RequestMapping(value = "/user/cs.do", method = RequestMethod.GET)
//	public String cs_page(Model model) {
//		// @@ 공지사항 목록 [10/11 월 한보영]
//		List<CsnoticeDTO> noticeList = noticeService.selectAll();
//		model.addAttribute("noticeList", noticeList);
//
//		// @@ 자주하는 질문 목록 [10/11 월 한보영]
//		List<OftenDTO> oftenList = noticeService.selectAll_often();
//		model.addAttribute("oftenList", oftenList);
//
//		return "user/cs";

}
