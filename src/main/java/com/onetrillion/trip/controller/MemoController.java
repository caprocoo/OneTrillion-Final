package com.onetrillion.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.admin.impl.AdminService;
import com.onetrillion.trip.logRecord.LogRecordDTO;
import com.onetrillion.trip.logRecord.impl.LogRecordService;
import com.onetrillion.trip.memo.MemoCriteria;
import com.onetrillion.trip.memo.MemoDTO;
import com.onetrillion.trip.memo.impl.MemoService;
import com.onetrillion.trip.page.PageMaker;

@Controller
@RequestMapping(value = "/adminMemo")
public class MemoController {
	
	@Autowired
	public MemoService memeoService;
	@Autowired
	public AdminService adminService;
	@Autowired
	public LogRecordService logService;

	public LogRecordDTO setLogRecord (String AD_ID, int seq, String log_content, String per_title) {
		//로그 번호(PK), 관리자 아이디, 파트, 파트번호, 내용(수정,입력, 삭제, ...), 활동날짜
		LogRecordDTO logRecord = new LogRecordDTO(0, AD_ID, "관리자 메모", seq, log_content, null, per_title);
		//System.out.println(logRecord);
		return logRecord;
	}
	
	//리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model, MemoCriteria cri) {

		List<AdminDTO> adminList = adminService.selectAll(); //관리자 전체 목록
		model.addAttribute("adminList", adminList);
		
		List<MemoDTO> memoList = memeoService.memoPaging(cri); //메모 리스트
		model.addAttribute("memoList", memoList);	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memeoService.memoCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminMemo/adminMemo";
	}
	//관리자 메인페이지 mini
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String admin_Mini(Model model){		
		List<MemoDTO> miniList = memeoService.selectAll();
		model.addAttribute("miniList", miniList);
		
		return "adminMemo/MemoMini";
	}
	
	//입력==========================================================================
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String input_p(MemoDTO dto ,Model model,HttpSession session) {		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "INSERT"; 
		LogRecordDTO memoInsertLog =  setLogRecord(AD_ID, dto.getMemo_seq(), log_content, dto.getMemo_type());
		
		logService.logRecordInsert(memoInsertLog);
		
		memeoService.insert(dto);
		return "redirect:/adminMemo/list.do";
	}
	
	//수정==========================================================================
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(@RequestParam("memo_seq") int memo_seq, Model model) {
		MemoDTO dto = memeoService.detail(memo_seq);
		model.addAttribute("dto", dto);
		
		List<AdminDTO> adminList = adminService.selectAll(); //관리자 전체 목록
		model.addAttribute("adminList", adminList);	
		return "adminMemo/MemoModify";
	}
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify_post(Model model, MemoDTO dto,HttpSession session) {		
		memeoService.modify(dto);
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "MODIFY"; 
		LogRecordDTO memoInsertLog =  setLogRecord(AD_ID, dto.getMemo_seq(), log_content, dto.getMemo_type());
		
		logService.logRecordInsert(memoInsertLog);
		return "redirect:/adminMemo/list.do";

	}
	
	//(삭제)==========================================================================
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete_post(MemoDTO dto,HttpSession session ) {		
		memeoService.delete(dto);
		//System.out.println(dto);
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "DELETE"; 
		LogRecordDTO memoInsertLog =  setLogRecord(AD_ID, dto.getMemo_seq(), log_content, dto.getMemo_type());
		
		logService.logRecordInsert(memoInsertLog);
		
		return "redirect:/adminMemo/list.do";
	}
	
	

}
