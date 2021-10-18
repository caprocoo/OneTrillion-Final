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

import com.onetrillion.trip.clientAnswer.ClientAnsDTO;
import com.onetrillion.trip.clientAnswer.Impl.ClientAnsService;
import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.clientque.Impl.ClientqueService;

@Controller
@RequestMapping(value = "/admin")
public class ClientAnsController {

	@Autowired
	ClientAnsService adminAns_service; //답변service

	@Autowired
	ClientqueService client_service; //문의service

	//@@(관리자)1:1문의 목록으로 이동============================================================================
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String adminAns_List(Model model) {			
		List<ClientqueDTO> clientQueList =client_service.selectAll(); //문의한 리스트 불러오기
		model.addAttribute("clientQueList", clientQueList);
		
		List<ClientAnsDTO> adminAnsList =adminAns_service.selectAll(); //답변 리스트
		model.addAttribute("adminAnsList", adminAnsList);
	
		 	return "mypage/adminPriQue";
	}
	//관리자 메인페이지 mini
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String admin_Mini(Model model){		
		List<ClientqueDTO> miniList = client_service.selectAll();
		model.addAttribute("miniList", miniList);
		
		return "mypage/priQueMini";
	}


	//@@(관리자 입력)1:1문의 입력페이지로 이동============================================================================
	@RequestMapping(value = "/input.do", method =RequestMethod.GET)
	public String adminAns_Insert(@RequestParam("cl_seq") int cl_seq, Model model, HttpServletResponse response) throws IOException {
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);	
		
		ClientAnsDTO ans_dto = adminAns_service.detail(cl_seq);	//답변 정보 detail 불러오기!!!		
			if(ans_dto==null) {				
				return "mypage/adminPriQueAnsInput"; //답변한게 없으면 입력창으로 이동
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
	
	//@@(관리자 입력)submit 완료!============================================================================
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String adminAns_Insert_post(ClientAnsDTO dto) {
		adminAns_service.insert(dto);	
		
		int cl_seq =dto.getCl_seq();
		client_service.getAdminAns(cl_seq); //답변가져와
			return "redirect:/admin/list.do";		
	}
	
	//@@(관리자 답변 상세)detail ====================================================================================
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) 
	public String adminAns_detail(@RequestParam("cl_seq") int cl_seq, Model model) {
		ClientAnsDTO ans_dto = adminAns_service.detail(cl_seq);	//답변 정보 detail 불러오기!!!
		model.addAttribute("ans_dto", ans_dto);
		
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);			
			return "mypage/adminPriQueDetail";
	}
	
	
	//(관리자 답변 수정) 페이지 이동 ====================================================================================
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String adminAns_modify(@RequestParam("cl_seq") int cl_seq, Model model) {		
		ClientqueDTO cl_dto = client_service.detail(cl_seq); //문의글(seq에따른) 정보 detail 불러오기!!!
		model.addAttribute("cl_dto", cl_dto);	
		
		ClientAnsDTO ans_dto = adminAns_service.detail(cl_seq);
		model.addAttribute("ans_dto", ans_dto);
			return "mypage/adminPriQueAnsModi";
	}
	
	//(관리자 수정 완료) submit ====================================================================================
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String adminAns_modify_post( Model model, ClientAnsDTO dto) {		
		adminAns_service.modify(dto);		
		int cl_seq =dto.getCl_seq();	
		client_service.getAdminAns(cl_seq); //답변가져와
			return "redirect:/admin/detail.do?cl_seq="+cl_seq;	

	}

	//(관리자 답변 삭제) ===========================================================================================
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String adminAns_delete_post(ClientAnsDTO dto) {
		adminAns_service.delete(dto);
	
		client_service.getAdminAns(	dto.getCl_seq()); //답변가져와
		return "redirect:/admin/list.do";	
	}
	
	//(문의글 삭제) 관리자list에서 ===========================================================================================
	@RequestMapping(value = "/delete2.do", method = RequestMethod.POST)
	public String clientQue_delete_post(ClientqueDTO dto, ClientAnsDTO adto) {		
		adminAns_service.delete(adto);
		client_service.delete(dto);//없어도될듯? 왜냐면 ON DELETE CASCADE 해서,, 일단 넣어놔
		return "redirect:/admin/list.do";
	}
	
	//(문의글 수정) 관리자list에서 ===========================================================================================
	@RequestMapping(value = "/modify2.do", method = RequestMethod.GET)
	public String clientQue_modify(@RequestParam("cl_seq") int cl_seq, Model model) {
		ClientqueDTO dto = client_service.detail(cl_seq);
		model.addAttribute("dto", dto);
		return "mypage/adminPriQueModi";
	}
	//(문의글 수정 완료) submit ===========================================================================================
	@RequestMapping(value = "/modify2.do", method = RequestMethod.POST)
	public String clientQue_modify_post(@RequestParam("cl_seq") int cl_seq, Model model, ClientqueDTO dto) {
		model.addAttribute("cl_seq", cl_seq);
		client_service.modify(dto);
		return "redirect:/admin/list.do";

	}
	
	
	
}
