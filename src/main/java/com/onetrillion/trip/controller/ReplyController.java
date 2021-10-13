package com.onetrillion.trip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.reply.ReplyDTO;
import com.onetrillion.trip.reply.impl.ReplyService;

@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
	
	@Autowired
	public ReplyService service;
	
	//2021. 10. 12 21:00 현성 리뷰 전체 리스트 구현
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String reply_List(Model model) {
		
		List<ReplyDTO> replyList = service.replySelectAll();
		model.addAttribute("replyList", replyList);

		return "reply/list";
	}
	
	
	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String reply_insert(Model model) {
		

		return "reply/insert";
	}
	
	
	
}
