package com.onetrillion.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.clientque.Impl.ClientqueService;


@Controller
@RequestMapping(value = "/myPage")
public class ClientQueController {

	@Autowired
	ClientqueService client_service;

	//1:1문의 목록으로 이동
	@RequestMapping(value = "Que/list.do", method = RequestMethod.GET)
	public String client_Que_List(Model model) {
		List<ClientqueDTO> clientQueList =client_service.selectAll();
		model.addAttribute("clientQueList", clientQueList);

		return "mypage/privateQue";
	}
	
	//1:1문의 입력페이지로 이동
	@RequestMapping(value = "Que/input.do", method =RequestMethod.GET)
	public String client_Que_Insert(Model model) {

		return "mypage/priQueInput";
	}
	
	//입력 submit누르면~
	@RequestMapping(value = "Que/input.do", method = RequestMethod.POST)
	public String client_Que_Insert_post(ClientqueDTO dto) {
		client_service.insert(dto);		
		return "redirect:Que/list.do";		
	}
	
	
}
