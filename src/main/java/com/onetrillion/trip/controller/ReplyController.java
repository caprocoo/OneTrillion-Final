package com.onetrillion.trip.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String reply_List(Model model, HttpSession session) {
		String u_id= (String) session.getAttribute("u_id");		

		//System.out.println(u_id);
		List<ReplyDTO> replyList = service.replySelectId(u_id);
		model.addAttribute("replyList", replyList);
		

		return "reply/list";
	}

	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String replyInsertPage(Model model, ReplyDTO dto) {
		
		//System.out.println(dto);
		model.addAttribute("replyInsertDto", dto);
		
		return "reply/insert";
	}
	
	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String replyInsertCommit(ReplyDTO dto) {
		
		//System.out.println(dto);
		service.replyInsert(dto);
		//System.out.println(u_id);
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
	
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String replyDeleteCommit(Model model, int reply_seq) {
		
		service.replyDelete(reply_seq);
		
		return "redirect:list.do";
	}
	
	
}
