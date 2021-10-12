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
	public String userSelectAll(Model model, String u_id){
		
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
	
	
}
