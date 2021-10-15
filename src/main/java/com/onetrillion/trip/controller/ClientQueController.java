package com.onetrillion.trip.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.adminAnswer.AdminAnsDTO;
import com.onetrillion.trip.adminAnswer.Impl.AdminAnsService;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.clientque.Impl.ClientqueService;



@Controller
@RequestMapping(value = "/myPage")
public class ClientQueController {

	@Autowired
	ClientqueService client_service;
	@Autowired
	AdminAnsService adminAns_service; //답변service


	//1:1문의 목록으로 이동
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String clientQue_List(Model model, HttpSession session) {
		String u_id= (String) session.getAttribute("u_id");		
		List<ClientqueDTO> clientQueList =client_service.selectOne(u_id); //문의한 리스트
		model.addAttribute("clientQueList", clientQueList);		
		
		List<AdminAnsDTO> adminAnsList =adminAns_service.selectAll(); //답변 리스트
		model.addAttribute("adminAnsList", adminAnsList);

		return "mypage/privateQue";
	}
	
	//1:1문의 입력페이지로 이동
	@RequestMapping(value = "/input.do", method =RequestMethod.GET)
	public String clientQue_Insert(Model model) {

		return "mypage/priQueInput";
	}
	
	//입력 submit 완료
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String clientQue_Insert_post(ClientqueDTO dto) {		
		int cnt = client_service.insert(dto);		
		if (cnt > 0) {
			return "redirect:/myPage/list.do";	
		}
		return "mypage/priQueInput";
	}
	
	//1:1 문의 게시글 수정 페이지 이동
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String clientQue_modify(@RequestParam("cl_seq") int cl_seq, Model model) {
		ClientqueDTO dto = client_service.detail(cl_seq);
		model.addAttribute("dto", dto);
		return "mypage/priQueModify";
	}
	//수정 submit 완료
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String clientQue_modify_post(@RequestParam("cl_seq") int cl_seq, Model model, ClientqueDTO dto) {
		model.addAttribute("cl_seq", cl_seq);
		client_service.modify(dto);
		return "redirect:/myPage/list.do";	

	}
	//삭제 완료(Ajax)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String clientQue_delete_post(ClientqueDTO dto) {
		client_service.delete(dto);
		return "redirect:/myPage/list.do";	
	}
	
	
}
