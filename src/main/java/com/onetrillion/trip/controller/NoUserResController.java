package com.onetrillion.trip.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.noUserRes.impl.NoUserResService;

@Controller
@RequestMapping(value = "/noUserRes")
public class NoUserResController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoUserResController.class);
	
	@Autowired
	public NoUserResService service;
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String noUserResInsert(){
		
		return null;
	}
	
	
}
