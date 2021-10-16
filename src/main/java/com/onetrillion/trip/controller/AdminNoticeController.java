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
import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.notice.Impl.NoticeService;

@Controller
@RequestMapping(value = "/adminNotice")
public class AdminNoticeController {
	
	@Autowired
	public NoticeService noticeService;
	
	//리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model) {
		List<CsnoticeDTO> noticeList = noticeService.selectAll();
		model.addAttribute("noticeList", noticeList);	
		
		return "adminNotice/adminNotice";
	}
	
	
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String input() {
		return "adminNotice/adminNoticeInput";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String input_p(CsnoticeDTO dto ,AdminDTO addto,HttpSession session,Model model) {
		
		session.setAttribute("AD_ID", addto.getAD_ID());

		
		noticeService.insert(dto);
		return "redirect:/adminNotice/list.do";
	}
	//(삭제)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete_post(CsnoticeDTO dto ) {		
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
	public String modify_post(Model model, CsnoticeDTO dto) {		
		noticeService.modify(dto);
		return "redirect:/adminNotice/list.do";

	}
	
	

}
