package com.onetrillion.trip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

	//@@(관리자)1:1문의 목록으로 이동============================================================================
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String adminAns_List(Model model) {			
		List<ClientqueDTO> clientQueList =client_service.selectAll(); //문의한 리스트 불러오기
		model.addAttribute("clientQueList", clientQueList);
		
		List<AdminAnsDTO> adminAnsList =adminAns_service.selectAll(); //답변 리스트
		model.addAttribute("adminAnsList", adminAnsList);
	
		 	return "mypage/AdminAnswer_list";
	}


	//@@(관리자)1:1문의 입력페이지로 이동============================================================================
	@RequestMapping(value = "/input.do", method =RequestMethod.GET)
	public String adminAns_Insert(@RequestParam("cl_seq") int cl_seq, Model model, HttpServletResponse response) throws IOException {
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);	
		
		AdminAnsDTO ans_dto = adminAns_service.detail(cl_seq);	//답변 정보 detail 불러오기!!!		
			if(ans_dto==null) {
				return "mypage/AdminAnswer_Input"; //답변한게 없으면 입력창으로 이동
			}else {			
				response.setContentType("text/html; charset=UTF-8"); //있으면 리스트로 돌아감
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('이미 답변한 문의글입니다')");
				out.println("location.href='javascript:history.back();'");
				out.println("</script>");
				out.flush();
				return null;
			}		
	}
	
	//@@(관리자)입력 submit 완료!============================================================================
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String adminAns_Insert_post(AdminAnsDTO dto) {		
		adminAns_service.insert(dto);		
			return "redirect:/admin/list.do";		
	}
	
	//@@(관리자)detail ====================================================================================
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) 
	public String adminAns_detail(@RequestParam("cl_seq") int cl_seq, Model model) {
		AdminAnsDTO ans_dto = adminAns_service.detail(cl_seq);	//답변 정보 detail 불러오기!!!
		model.addAttribute("ans_dto", ans_dto);
		
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);			
			return "mypage/AdminAnswer_detail";
	}
	
	
	//답변 수정 페이지 이동 ====================================================================================
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String adminAns_modify(@RequestParam("cl_seq") int cl_seq, Model model) {		
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);	
		
		AdminAnsDTO ans_dto = adminAns_service.detail(cl_seq);
		model.addAttribute("ans_dto", ans_dto);
			return "mypage/AdminAnswer_modify";
	}
	
	//수정 submit 완료 ====================================================================================
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String adminAns_modify_post( Model model, AdminAnsDTO dto) {		
		adminAns_service.modify(dto);		
		int cl_seq =dto.getCl_seq();		
			return "redirect:/admin/detail.do?cl_seq="+cl_seq;	

	}

	//삭제 완료 ===========================================================================================
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String adminAns_delete_post(AdminAnsDTO dto) {
		adminAns_service.delete(dto);
		return "redirect:/admin/list.do";	
	}
	
	
}
