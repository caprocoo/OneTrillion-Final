package com.onetrillion.trip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.noUserRes.NoUserResCriteria;
import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.noUserRes.impl.NoUserResService;
import com.onetrillion.trip.page.PageMaker;


@Controller
@RequestMapping(value = "/adminNoUserRes")
public class AdminNoUserResController {

	@Autowired
	public NoUserResService service;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String AdminNoUserResListPaging(Model model, NoUserResCriteria cri) {
		
		List<NoUserResDTO> noUserResList = service.noUserResPaging(cri);
		System.out.println(noUserResList);
		model.addAttribute("noUserResList", noUserResList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.noUserResCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "adminNoUserRes/adminNoRes";
	}
	
	@RequestMapping(value = "/listMini.do", method = RequestMethod.GET)
	public String AdminNoUserResMini(Model model){
		
		List<NoUserResDTO> noUserResList = service.noUserSelectAll();
		model.addAttribute("noUserResList", noUserResList);
		
		return "adminNoUserRes/adminNoResMini";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String AdminNoUserResInsert(){
		return "adminNoUserRes/adminNoResInput";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String AdminNoUserResInsertCommit(NoUserResDTO dto){
		service.noUserResInsert(dto);
		return "redirect:list.do";
	}
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String AdminNoUserResModify(Model model, int res_seq){

		
		NoUserResDTO noUserResDetail = service.adminNoUserDetail(res_seq);
		model.addAttribute("noUserResDetail", noUserResDetail);
		return "adminNoUserRes/adminNoResModi";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String AdminNoUserResModifyCommit(NoUserResDTO dto){
		service.noUserResModify(dto);
		
		return "redirect:list.do";
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String AdminNoUserResDeleteCommit(int res_seq){
		//System.out.println(ures_seq);
		service.noUserResDelete(res_seq);
		return "redirect:list.do";
	}
	
	
	
}
