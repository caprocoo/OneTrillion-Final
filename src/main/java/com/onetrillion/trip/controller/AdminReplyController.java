package com.onetrillion.trip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.page.PageMaker;
import com.onetrillion.trip.reply.ReplyCriteria;
import com.onetrillion.trip.reply.ReplyDTO;
import com.onetrillion.trip.reply.impl.ReplyService;


@Controller
@RequestMapping(value = "/adminReply")
public class AdminReplyController {
	
	@Autowired
	public ReplyService service;
	
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String AdminReplyListPaging(Model model, ReplyCriteria cri) {
		
		List<ReplyDTO> replyList = service.replyPaging(cri);
		model.addAttribute("replyList", replyList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.replyCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminReply/adminReview";
	}
	
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String AdminReplyResMini(Model model){
		
		List<ReplyDTO> replyList = service.replySelectAll();
		model.addAttribute("replyList", replyList);
		
		return "adminReply/adminReplyMini";
	}
	
	
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String AdminReplyInsert(){
		return "adminReply/adminReviewInput";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String AdminReplyInsertCommit(ReplyDTO dto){
		
		//System.out.println(dto);
		service.replyInsert(dto);
		
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String AdminReplyModify(Model model, int reply_seq){
		
		ReplyDTO replyDetail = service.replyDetail(reply_seq);
		model.addAttribute("replyDetail", replyDetail);
		
		return "adminReply/adminReviewModi";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String AdminReplyModifyCommit(ReplyDTO dto){
		
		service.replyModify(dto);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String AdminReplyDeleteCommit(int reply_seq){
		
		service.replyDelete(reply_seq);
		return "redirect:list.do";
	}
	
	
	
	
}
