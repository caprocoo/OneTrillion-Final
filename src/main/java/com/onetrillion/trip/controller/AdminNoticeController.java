package com.onetrillion.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.notice.Impl.NoticeService;

@Controller
@RequestMapping(value = "/adminNotice")
public class AdminNoticeController {
	
	@Autowired
	public NoticeService noticeService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model) {
		List<CsnoticeDTO> noticeList = noticeService.selectAll();
		model.addAttribute("noticeList", noticeList);		
		
		return "adminOften/adminOften";
	}

}
