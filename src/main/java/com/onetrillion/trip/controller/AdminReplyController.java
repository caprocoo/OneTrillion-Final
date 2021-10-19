package com.onetrillion.trip.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.logRecord.LogRecordDTO;
import com.onetrillion.trip.logRecord.impl.LogRecordService;
import com.onetrillion.trip.page.PageMaker;
import com.onetrillion.trip.reply.ReplyCriteria;
import com.onetrillion.trip.reply.ReplyDTO;
import com.onetrillion.trip.reply.impl.ReplyService;


@Controller
@RequestMapping(value = "/adminReply")
public class AdminReplyController {
	
	@Autowired
	public ReplyService service;
	
	@Autowired
	public LogRecordService logService;
	
	public LogRecordDTO setLogRecord (String AD_ID, int seq, String log_content, String per_title) {
		//로그 번호(PK), 관리자 아이디, 파트, 파트번호, 내용(수정,입력, 삭제, ...), 활동날짜
		LogRecordDTO logRecord = new LogRecordDTO(0, AD_ID, "후기", seq, log_content, null,per_title);
		
		//System.out.println(logRecord);
		return logRecord;
	}
	
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
	public String AdminReplyInsertCommit(ReplyDTO dto, HttpSession session){
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "INSERT"; 
		LogRecordDTO replyInstertLog =  setLogRecord(AD_ID, dto.getReply_seq(), log_content, dto.getReply_title());
		
		logService.logRecordInsert(replyInstertLog);
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
	public String AdminReplyModifyCommit(ReplyDTO dto, HttpSession session){
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "MODIFY"; 
		LogRecordDTO replyInstertLog =  setLogRecord(AD_ID, dto.getReply_seq(), log_content,dto.getReply_title());
		logService.logRecordInsert(replyInstertLog);
		
		service.replyModify(dto);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String AdminReplyDeleteCommit(int reply_seq, HttpSession session, String per_title){
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "DELETE"; 
		LogRecordDTO replyInstertLog =  setLogRecord(AD_ID, reply_seq, log_content, per_title);
		logService.logRecordInsert(replyInstertLog);
		
		service.replyDelete(reply_seq);
		return "redirect:list.do";
	}
	
	
	
	
}
