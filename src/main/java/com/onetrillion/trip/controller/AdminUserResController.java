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
import com.onetrillion.trip.userRes.UserResCriteria;
import com.onetrillion.trip.userRes.UserResDTO;
import com.onetrillion.trip.userRes.impl.UserResService;

@Controller
@RequestMapping(value = "/adminUserRes")
public class AdminUserResController {

	@Autowired
	public UserResService service;
	@Autowired
	public LogRecordService logService;

	public LogRecordDTO setLogRecord(String AD_ID, int seq, String log_content, String per_title) {
		// 로그 번호(PK), 관리자 아이디, 파트, 파트번호, 내용(수정,입력, 삭제, ...), 활동날짜
		LogRecordDTO logRecord = new LogRecordDTO(0, AD_ID, "회원 예약하기", seq, log_content, null, per_title);
		//System.out.println(logRecord);
		return logRecord;
	}

	
	  @RequestMapping(value = "/list.do", method = RequestMethod.GET) public String
	  AdminUserResListPaging(Model model, UserResCriteria cri,HttpSession session){
	  
	  List<UserResDTO> userResList = service.userResPaging(cri);
	  model.addAttribute("userResList", userResList);
	  
	  PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
	  pageMaker.setTotalCount(service.userResCount());
	  
	  model.addAttribute("pageMaker", pageMaker);
	  
	  
	  return "adminUserRes/adminRes"; }
	 

	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String AdminUserResMini(Model model) {

		List<UserResDTO> userResList = service.userSelectAll();
		model.addAttribute("userResList", userResList);

		return "adminUserRes/adminResMini";
	}

	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String AdminUserResModify(Model model, int ures_seq) {

		UserResDTO userResDetail = service.userResDetail(ures_seq);
		model.addAttribute("userResDetail", userResDetail);

		return "adminUserRes/adminResModi";
	}

	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String AdminUserResModifyCommit(UserResDTO dto, HttpSession session) {
		System.out.println(dto);
		String AD_ID = (String) session.getAttribute("AD_ID");
		String log_content = "MODIFY";
		LogRecordDTO userInsertLog = setLogRecord(AD_ID, dto.getUres_seq(), log_content, dto.getPd_name());

		logService.logRecordInsert(userInsertLog);

		service.userResModify(dto);
		return "redirect:list.do";
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String AdminUserResDeleteCommit(int ures_seq, HttpSession session, String per_title) {

		String AD_ID = (String) session.getAttribute("AD_ID");
		String log_content = "DELETE";
		LogRecordDTO userInsertLog = setLogRecord(AD_ID, ures_seq, log_content, per_title);
		logService.logRecordInsert(userInsertLog);

		service.userResDelete(ures_seq);
		return "redirect:list.do";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String AdminUserResInsert() {

		return "adminUserRes/adminResInput";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String AdminUserResInsertCommit(UserResDTO dto, HttpSession session) {
		//System.out.println(dto);
		String AD_ID = (String) session.getAttribute("AD_ID");
		String log_content = "INSERT";
		LogRecordDTO userInsertLog = setLogRecord(AD_ID, dto.getUres_seq(), log_content, dto.getPd_name());

		logService.logRecordInsert(userInsertLog);

		service.userResInsert(dto);

		return "redirect:list.do";
	}

}
