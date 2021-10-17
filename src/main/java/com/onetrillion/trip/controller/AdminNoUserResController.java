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
import com.onetrillion.trip.noUserRes.NoUserResCriteria;
import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.noUserRes.impl.NoUserResService;
import com.onetrillion.trip.page.PageMaker;


@Controller
@RequestMapping(value = "/adminNoUserRes")
public class AdminNoUserResController {

	@Autowired
	public NoUserResService service;
	@Autowired
	public LogRecordService logService;
	
	
	public LogRecordDTO setLogRecord (String AD_ID, int seq, String log_content, String per_title) {
		//로그 번호(PK), 관리자 아이디, 파트, 파트번호, 내용(수정,입력, 삭제, ...), 활동날짜
		LogRecordDTO logRecord = new LogRecordDTO(0, AD_ID, "비회원 예약하기", seq, log_content, null, per_title);
		System.out.println(logRecord);
		return logRecord;
	}
	

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String AdminNoUserResListPaging(Model model, NoUserResCriteria cri) {
		
		List<NoUserResDTO> noUserResList = service.noUserResPaging(cri);
		//System.out.println(noUserResList);
		model.addAttribute("noUserResList", noUserResList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.noUserResCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminNoUserRes/adminNoRes";
	}
	
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String AdminNoUserResMini(Model model){
		
		List<NoUserResDTO> noUserResList = service.noUserSelectAll();
		model.addAttribute("noUserResList", noUserResList);
		
		return "adminNoUserRes/adminNoResMini";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String AdminNoUserResInsert(){
		return "adminNoUserRes/adminNoResInput";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String AdminNoUserResInsertCommit(NoUserResDTO dto, HttpSession session){
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "INSERT"; 
		LogRecordDTO noUserInsertLog =  setLogRecord(AD_ID, dto.getRes_seq(), log_content, dto.getPd_name());
		
		logService.logRecordInsert(noUserInsertLog);
		
		service.noUserResInsert(dto);
		return "redirect:list.do";
	}
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String AdminNoUserResModify(Model model, int res_seq){

		NoUserResDTO noUserResDetail = service.adminNoUserDetail(res_seq);
		model.addAttribute("noUserResDetail", noUserResDetail);
		return "adminNoUserRes/adminNoResModi";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String AdminNoUserResModifyCommit(NoUserResDTO dto, HttpSession session){
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "MODIFY"; 
		LogRecordDTO noUserInsertLog =  setLogRecord(AD_ID, dto.getRes_seq(), log_content, dto.getPd_name());
		
		logService.logRecordInsert(noUserInsertLog);
		
		service.noUserResModify(dto);
		
		return "redirect:list.do";
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String AdminNoUserResDeleteCommit(int res_seq, HttpSession session, String per_title){
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "DELETE"; 
		LogRecordDTO noUserInsertLog =  setLogRecord(AD_ID, res_seq, log_content, per_title);
		logService.logRecordInsert(noUserInsertLog);
		
		service.noUserResDelete(res_seq);
		return "redirect:list.do";
	}
	
	
	
}
