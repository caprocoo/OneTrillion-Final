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
	public String replyInsertPage() {
		return "reply/insert";
	}
	
	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String replyInsertCommit(Model model, ReplyDTO dto) {
		
		//System.out.println(dto);
		service.replyInsert(dto);

		return "redirect:list.do";
	}
	
	@RequestMapping(value = "modify.do", method = RequestMethod.GET)
	public String replyModifyPage(Model model, int reply_seq) {
		ReplyDTO dto= service.replyDetail(reply_seq);
		//System.out.println(dto);
		model.addAttribute("replyDetail", dto);
		return "reply/modify";
	}
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String replyModifyCommit(Model model, ReplyDTO dto) {
		//System.out.println(dto);
		service.replyModify(dto);
		
		return "redirect:list.do";
	}
	
	
	
}
