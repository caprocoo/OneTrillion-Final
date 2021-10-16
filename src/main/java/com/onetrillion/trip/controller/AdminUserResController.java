package com.onetrillion.trip.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.page.PageMaker;
import com.onetrillion.trip.userRes.UserResCriteria;
import com.onetrillion.trip.userRes.UserResDTO;
import com.onetrillion.trip.userRes.impl.UserResService;

@Controller
@RequestMapping(value = "/adminUserRes")
public class AdminUserResController {

	@Autowired
	public UserResService service;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String AdminUserResListPaging(Model model, UserResCriteria cri) {
		
		List<UserResDTO> userResList = service.userResPaging(cri);
		model.addAttribute("userResList", userResList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.userResCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminUserRes/adminRes";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String AdminUserResModify(Model model, int ures_seq){
		//System.out.println(ures_seq);
		
		UserResDTO userResDetail = service.userResDetail(ures_seq);
		model.addAttribute("userResDetail", userResDetail);

		return "adminUserRes/adminResModi";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String AdminUserResModifyCommit(UserResDTO dto){
		
		service.userResModify(dto);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String AdminUserResDeleteCommit(int ures_seq){
		//System.out.println(ures_seq);
		service.userResDelete(ures_seq);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String AdminUserResInsert(){
		
		return "adminUserRes/adminResInput";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String AdminUserResInsertCommit(UserResDTO dto){
		
		//System.out.println(dto);
		service.userResInsert(dto);
		
		return "redirect:list.do";
	}
	
	
}
