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
import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.notice.NoticeCriteria;
import com.onetrillion.trip.notice.Impl.NoticeService;
import com.onetrillion.trip.page.PageMaker;

@Controller
@RequestMapping(value = "/adminNotice")
public class AdminNoticeController {
	
	@Autowired
	public NoticeService noticeService;
	@Autowired
	public LogRecordService logService;
	
	public LogRecordDTO setLogRecord (String AD_ID, int seq, String log_content, String per_title) {
		//로그 번호(PK), 관리자 아이디, 파트, 파트번호, 내용(수정,입력, 삭제, ...), 활동날짜
		LogRecordDTO logRecord = new LogRecordDTO(0, AD_ID, "공지사항", seq, log_content, null, per_title);
		//System.out.println(logRecord);
		return logRecord;
	}
	
	
	//리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model, NoticeCriteria cri) {
		List<CsnoticeDTO> noticeList = noticeService.noticePaging(cri);
		model.addAttribute("noticeList", noticeList);	
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeService.noticeCount());
		
		model.addAttribute("pageMaker", pageMaker);
				
		return "adminNotice/adminNotice";
	}
	
	
	
	//관리자 메인페이지 mini
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String admin_Mini(Model model){		
		List<CsnoticeDTO> miniList = noticeService.selectAll();
		model.addAttribute("miniList", miniList);
		
		return "adminNotice/noticeMini";
	}
	
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String input() {
		return "adminNotice/adminNoticeInput";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String input_p(CsnoticeDTO dto ,HttpSession session,Model model) {
		
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "INSERT"; 
		LogRecordDTO noticeInsertLog =  setLogRecord(AD_ID, dto.getNo_seq(), log_content, dto.getNo_title());
		
		logService.logRecordInsert(noticeInsertLog);
		
		
		noticeService.insert(dto);
		return "redirect:/adminNotice/list.do";
	}
	//(삭제)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete_post(CsnoticeDTO dto,HttpSession session, String per_title) {		
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "DELETE"; 
		LogRecordDTO noticeInsertLog =  setLogRecord(AD_ID, dto.getNo_seq(), log_content, per_title);
		
		logService.logRecordInsert(noticeInsertLog);
		noticeService.delete(dto);
		return "redirect:/adminNotice/list.do";
	}
	
	//수정
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(@RequestParam("no_seq") int no_seq, Model model) {
		CsnoticeDTO dto = noticeService.detail(no_seq);
		model.addAttribute("dto", dto);
		
		
		
		return "adminNotice/adminNoticeModi";
	}
	//수정완료
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify_post(Model model, CsnoticeDTO dto, HttpSession session) {		
		
		
		String AD_ID = (String) session.getAttribute("AD_ID");	
		String log_content = "MODIFY"; 
		LogRecordDTO noticeInsertLog =  setLogRecord(AD_ID, dto.getNo_seq(), log_content, dto.getNo_title());
		
		logService.logRecordInsert(noticeInsertLog);
		
		noticeService.modify(dto);
		return "redirect:/adminNotice/list.do";

	}
	
	

}
