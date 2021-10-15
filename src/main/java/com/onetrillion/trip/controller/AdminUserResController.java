package com.onetrillion.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/adminUserRes")
public class AdminUserResController {

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String AdminLoginPage() {
		return "adminUserRes/adminRes";
	}
	
	
}
