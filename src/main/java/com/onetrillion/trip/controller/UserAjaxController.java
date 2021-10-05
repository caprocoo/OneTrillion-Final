package com.onetrillion.trip.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.user.UserDTO;
import com.onetrillion.trip.user.Impl.UserServiceImpl;



@Controller
@RequestMapping(value="/user")
public class UserAjaxController {
	
	
	@Autowired
	public UserServiceImpl service;
	
	
	
	@RequestMapping(value="/idCheckAjax.do", method=RequestMethod.GET)
	@ResponseBody
	public String idCheckAjax(@RequestParam("id") String id) {
		String result = "impossible";
		
		UserDTO user = service.oneUser_id(id);
		// DB에 ID값이 없으면
		if(user == null) {
			result = "possible";
		}
		return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
