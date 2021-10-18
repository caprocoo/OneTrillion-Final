package com.onetrillion.trip.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.admin.impl.AdminService;
import com.onetrillion.trip.memo.MemoDTO;
import com.onetrillion.trip.memo.impl.MemoService;

@Controller
@RequestMapping(value = "/adminMemo")
public class MemoController {
	
	@Autowired
	public MemoService memeoService;
	@Autowired
	AdminService adminService;

	
	//리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model) {
		List<MemoDTO> memoList = memeoService.selectAll(); //메모 리스트
		model.addAttribute("memoList", memoList);	
		
		List<AdminDTO> adminList = adminService.selectAll(); //관리자 전체 목록
		model.addAttribute("adminList", adminList);	
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
	public String input_p(MemoDTO dto ,Model model) {			
		memeoService.insert(dto);
		return "redirect:/adminMemo/list.do";
	}
	//(삭제)==========================================================================
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete_post(MemoDTO dto ) {		
		memeoService.delete(dto);
	
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
	public String modify_post(Model model, MemoDTO dto) {		
		memeoService.modify(dto);
		return "redirect:/adminMemo/list.do";

	}
	
	

}
