package com.onetrillion.trip.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.userRes.UserResDTO;
import com.onetrillion.trip.userRes.impl.UserResService;

@Controller
@RequestMapping(value = "/userRes")
public class UserResController {
	private static final Logger logger = LoggerFactory.getLogger(UserResController.class);
	
	@Autowired
	public UserResService service;
	
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String userResInsert(){
		
		return null;
	}
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String userSelectAll(Model model){
		
		List<UserResDTO> userResList = service.userSelectAll();
		model.addAttribute("userResList", userResList);
		return "userRes/list";
	}
}
