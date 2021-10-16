package com.onetrillion.trip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.often.impl.OftenService;


@Controller
@RequestMapping(value = "/adminOften") //==10/16 자주묻는질문 한보영
public class AdminOftenController {
	
	@Autowired
	public OftenService oftenService; // @@ 공지사항&자주하는질문 
	
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String adminOften(Model model) {
		List<OftenDTO> oftenList = oftenService.selectAll_often();
		model.addAttribute("oftenList", oftenList);		
		
		return "adminOften/adminOften";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String often_input() {
		return "adminOften/adminOftenInput";
	}
	//입력
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String often_input_p(OftenDTO dto ) {
		oftenService.insert(dto);
		return "redirect:/adminOften/list.do";
	}
	//(삭제)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete_post(OftenDTO dto ) {		
		oftenService.delete(dto);
	
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
	public String modify_post(Model model, OftenDTO dto) {		
		oftenService.modify(dto);
		return "redirect:/adminOften/list.do";

	}
	
	
	
}
