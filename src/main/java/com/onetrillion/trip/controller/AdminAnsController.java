package com.onetrillion.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.adminAnswer.AdminAnsDTO;
import com.onetrillion.trip.adminAnswer.Impl.AdminAnsService;
import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.clientque.Impl.ClientqueService;




@Controller
@RequestMapping(value = "/admin")
public class AdminAnsController {

	@Autowired
	AdminAnsService adminAns_service; //답변service

	@Autowired
	ClientqueService client_service; //문의service

	//(관리자)1:1문의 목록으로 이동
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String adminAns_List(Model model) {				
		
		
		//List<AdminAnsDTO> answerAllList =adminAns_service.selectAll();
		//model.addAttribute("answerAllList", answerAllList);		
		
		List<ClientqueDTO> clientQueList =client_service.selectAll();
		model.addAttribute("clientQueList", clientQueList);

		return "mypage/AdminAnswerlist";
	}
	
	//(관리자)1:1문의 입력페이지로 이동
	@RequestMapping(value = "/input.do", method =RequestMethod.GET)
	public String adminAns_Insert(@RequestParam("cl_seq") int cl_seq, Model model) {
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);		
		return "mypage/AdminAnswerInput";
	}
	
	//(관리자)입력 submit 완료!
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String adminAns_Insert_post(AdminAnsDTO dto) {		
		System.out.println("AdminAnsDTO dto들어옴?>>"+dto);
		int cnt = adminAns_service.insert(dto);		
		if (cnt > 0) {
			return "redirect:/admin/list.do";	
		}
		return  "mypage/AdminAnswerInput";
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) 
	public String adminAns_detail(@RequestParam("cl_seq") int cl_seq, Model model) {
		AdminAnsDTO ans_dto = adminAns_service.detail(cl_seq);	//답변 정보 detail 불러오기!!!
		System.out.println("디테일ans_dto>>"+ans_dto);
		model.addAttribute("ans_dto", ans_dto);
		
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);				
		
		return "mypage/AdminAnswerdetail";
	}
	
	
	
	
//	
//	//수정 페이지 이동
//	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
//	public String adminAns_modify(@RequestParam("cl_seq") int cl_seq, Model model) {
//		AdminAnsDTO dto = adminAns_service.detail(cl_seq);
//		model.addAttribute("dto", dto);
//		return "mypage/priQueModify";
//	}
//	//수정 submit 완료
//	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
//	public String adminAns_modify_post(@RequestParam("ans_seq") int ans_seq, Model model, AdminAnsDTO dto) {
//		model.addAttribute("ans_seq", ans_seq);
//		adminAns_service.modify(dto);
//		return "redirect:/myPage/list.do";	
//
//	}
//
//	//삭제 완료
//	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
//	public String adminAns_delete_post(AdminAnsDTO dto) {
//		adminAns_service.delete(dto);
//		return "redirect:/myPage/list.do";	
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
