package com.onetrillion.trip.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.community.CommunityDTO;
import com.onetrillion.trip.community.impl.CommunityService;



@Controller
@RequestMapping(value = "/community")
public class CommunityController {

	@Autowired
	CommunityService service;



	//1:1문의 목록으로 이동
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String List(Model model, HttpSession session) {
				
		List<CommunityDTO> commuList =service.selectAll(); //답변 리스트
		model.addAttribute("commuList", commuList);

		return "community/list";
	}
	
	//@@(관리자 답변 상세)detail ====================================================================================
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) 
	public String adminAns_detail(@RequestParam("com_seq") int com_seq, Model model) {
		CommunityDTO dto = service.detail(com_seq);	
		model.addAttribute("dto", dto);
		System.out.println(dto );
		
		dto.setCom_cnt(dto.getCom_cnt() + 1);
		service.cntUp(dto); // 조회수 증가
		return "community/detail";
	}
	

	
	
	//입력페이지로 이동
	@RequestMapping(value = "/input.do", method =RequestMethod.GET)
	public String comm_Insert(Model model) {

		return "community/input";
	}
	
	//입력 submit 완료
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String comm_Insert_post(CommunityDTO dto) {		
		service.insert(dto);		
		
		return "redirect:/community/list.do";	
		
	}
	
	//게시글 수정 페이지 이동
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String comm_modify(@RequestParam("com_seq") int com_seq, Model model) {
		CommunityDTO dto = service.detail(com_seq);
		model.addAttribute("dto", dto);
		return "community/modify";
	}
	//수정 submit 완료
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String comm_modify_post(@RequestParam("com_seq") int com_seq, Model model, CommunityDTO dto) {
		model.addAttribute("com_seq", com_seq);
		service.modify(dto);
		return "redirect:/community/list.do";	

	}
	//삭제 완료(Ajax)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String comm_delete_post(CommunityDTO dto) {
		service.delete(dto);
		return "redirect:/community/list.do";	
	}

	
	
}
