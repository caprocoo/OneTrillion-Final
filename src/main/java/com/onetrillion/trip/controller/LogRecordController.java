package com.onetrillion.trip.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.logRecord.LogRecordCriteria;
import com.onetrillion.trip.logRecord.LogRecordDTO;
import com.onetrillion.trip.logRecord.impl.LogRecordService;
import com.onetrillion.trip.page.PageMaker;




@Controller
@RequestMapping(value = "/logRecord")
public class LogRecordController {
	
	@Autowired
	public LogRecordService service;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String noUserSelectAll(Model model, LogRecordCriteria cri){
		
		List<LogRecordDTO> logRecordList = service.LogRecordPaging(cri);
		model.addAttribute("logRecordList", logRecordList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.LogRecordCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminLogRecord/adminLogRecord";
	}

}
