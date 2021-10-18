package com.onetrillion.trip.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.logRecord.LogRecordDTO;
import com.onetrillion.trip.logRecord.impl.LogRecordService;
import com.onetrillion.trip.often.OftenCriteria;
import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.often.impl.OftenService;
import com.onetrillion.trip.page.PageMaker;


@Controller
@RequestMapping(value = "/adminOften") //==10/16 자주묻는질문 한보영
public class AdminOftenController {
	
	@Autowired
	public OftenService oftenService; // @@ 공지사항&자주하는질문
	
	@Autowired
	public LogRecordService logService;
	
	public LogRecordDTO setLogRecord (String AD_ID, int seq, String log_content, String per_title) {
		//로그 번호(PK), 관리자 아이디, 파트, 파트번호, 내용(수정,입력, 삭제, ...), 활동날짜
		LogRecordDTO logRecord = new LogRecordDTO(0, AD_ID, "자주묻는질문", seq, log_content, null, per_title);
		System.out.println(logRecord);
		return logRecord;
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String adminOften(Model model, OftenCriteria cri) {
		List<OftenDTO> oftenList = oftenService.oftenPaging(cri);
		model.addAttribute("oftenList", oftenList);		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(oftenService.oftenCount());
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminOften/adminOften";
	}
	//[관리자] 메인페이지 mini
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String admin_Mini(Model model){		
		List<OftenDTO> miniList = oftenService.selectAll_often();
		model.addAttribute("miniList", miniList);
		
		return "adminOften/oftenMini";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String often_input() {
		return "adminOften/adminOftenInput";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String often_input_p(OftenDTO dto,HttpSession session ) {
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "INSERT"; 
		LogRecordDTO oftenInsertLog =  setLogRecord(AD_ID, dto.getOf_seq(), log_content, dto.getOf_title());
		
		logService.logRecordInsert(oftenInsertLog);
		oftenService.insert(dto);
		return "redirect:/adminOften/list.do";
	}
	
	//수정
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(@RequestParam("of_seq") int of_seq, Model model) {
		OftenDTO dto = oftenService.detail(of_seq);
		model.addAttribute("dto", dto);
		return "adminOften/adminOftenModi";
	}
	//수정완료
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify_post(Model model, OftenDTO dto,HttpSession session) {	
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "MODIFY"; 
		LogRecordDTO oftenInsertLog =  setLogRecord(AD_ID, dto.getOf_seq(), log_content, dto.getOf_title());
		
		logService.logRecordInsert(oftenInsertLog);
		oftenService.modify(dto);
		return "redirect:/adminOften/list.do";

	}
	//(삭제)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete_post(OftenDTO dto,HttpSession session, String per_title ) {
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "DELETE"; 
		LogRecordDTO oftenInsertLog =  setLogRecord(AD_ID, dto.getOf_seq(), log_content, per_title);
		logService.logRecordInsert(oftenInsertLog);
		oftenService.delete(dto);
		
		return "redirect:/adminOften/list.do";
	}
	
	
	
}
