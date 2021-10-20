package com.onetrillion.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.komment.KommentDTO;
import com.onetrillion.trip.komment.impl.KommentService;


@Controller
@RequestMapping(value = "/komment")
public class KommentController {
	
	@Autowired
	KommentService service;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String commentList(Model model) {
		List<KommentDTO> kommentList = service.kommentSelectAll();
		model.addAttribute("kommentList", kommentList);
		
		return "komment/list";
	}
	
	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String kommentInsertPage(Model model, KommentDTO dto) {
		
		//System.out.println(dto);
		model.addAttribute("kommentInsertDto", dto);
		
		return "komment/insert";
	}
	
	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String kommentInsertCommit(KommentDTO dto) {
		
		//System.out.println(dto);
		service.kommentInsert(dto);

		return "redirect:list.do";
	}
	
	@RequestMapping(value = "modify.do", method = RequestMethod.GET)
	public String kommentModifyPage(Model model, int kom_seq) {
		//System.out.println(dto);
		KommentDTO dto = service.kommentDetail(kom_seq);
		model.addAttribute("kommentDetail", dto);
		
		return "komment/modify";
	}
	
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String kommentModfiyCommit(KommentDTO dto) {
		
		//System.out.println(dto);
		service.kommentModify(dto);

		return "redirect:list.do";
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String kommentDeleteCommit(int kom_seq) {
		
		service.kommentDelete(kom_seq);
		
		return "redirect:list.do";
	}
	
	
	
	
}
