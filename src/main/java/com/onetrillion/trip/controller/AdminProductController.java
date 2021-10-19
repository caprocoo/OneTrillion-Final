package com.onetrillion.trip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;

@Controller
@RequestMapping(value = "/adminProduct")
public class AdminProductController {

	@Autowired
	public BoardService service;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model) {
		List<BoardDTO> pdList = service.selectAll();
		model.addAttribute("pdList", pdList);
		return "adminProduct/adminPd";
	}
	
	//관리자 상품 수정 페이지 이동
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyGet(@RequestParam("pd_seq") int pd_seq, Model model) {
		BoardDTO list = service.detail(pd_seq);
		model.addAttribute("list", list);
		return "adminProduct/adminPdModi";
	}
	
	//관리자 상품 수정 완료(Ajax)
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modifyPost(@RequestParam("pd_seq") int pd_seq, Model model, BoardDTO dto) {
		model.addAttribute("pd_seq", pd_seq);
		service.modify(dto);
		return "redirect:/adminProduct/list.do";
	}
	
	//관리자가 상품 삭제 완료(Ajax)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deletePost(BoardDTO dto) {
		service.delete(dto);
		return "redirect:/adminProduct/list.do";
	}
	
	//관리자 상품 입력 페이지 이동
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String insertGet() {
		return "adminProduct/adminPdInput";
	}
	
	//관리자 상품 입력 페이지 이동
	@RequestMapping(value = "/mini.do", method = RequestMethod.GET)
	public String mini(Model model) {
		List<BoardDTO> pdList = service.selectAll();
		model.addAttribute("pdList", pdList);
		return "adminProduct/adminPdMini";
	}
	
	
	//관리자 상품 입력 완료
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String insertPost(BoardDTO dto) {
		System.out.println(dto);
		int cnt = service.insert(dto);
		if (cnt > 0) {
			return "redirect:/adminProduct/list.do";
		}
		return "adminProduct/adminPdInput";
	}

}
