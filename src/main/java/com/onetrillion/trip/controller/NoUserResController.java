package com.onetrillion.trip.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.noUserRes.impl.NoUserResService;

@Controller
@RequestMapping(value = "/noUserRes")
public class NoUserResController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoUserResController.class);
	
	@Autowired
	public NoUserResService service;
	
	//2021. 10. 11 19:35 현성 noUserReservation -회원 예약하기 전체 리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String noUserSelectAll(Model model){
		
		List<NoUserResDTO> noUserResList = service.noUserSelectAll();
		model.addAttribute("noUserResList", noUserResList);
		
		return "noUserRes/list";
	}
	//2021. 10. 11 19:35 현성 noUserReservation -비회원 예약하기 insert 구현
	@RequestMapping(value = "/finished.do", method = RequestMethod.POST)
	@ResponseBody
	public String noUserResInsert(NoUserResDTO dto){
		//System.out.println(dto);
		service.noUserResInsert(dto);
		return null;
	}
	
	
}
