package com.onetrillion.trip.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.userRes.UserResDTO;
import com.onetrillion.trip.userRes.impl.UserResService;

@Controller
@RequestMapping(value = "/userRes")
public class UserResController {
	private static final Logger logger = LoggerFactory.getLogger(UserResController.class);
	
	@Autowired
	public UserResService service;
	
	

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String userSelectAll(Model model, UserResDTO dto){
		
		List<UserResDTO> userResList = service.userSelectAll();
		model.addAttribute("userResList", userResList);


		return "userRes/list";
	}
	
	@RequestMapping(value = "/finished.do", method = RequestMethod.POST)
	@ResponseBody
	public String userResInsert(UserResDTO dto){
		
		service.userResInsert(dto);
		
		return "success";
	}
}
