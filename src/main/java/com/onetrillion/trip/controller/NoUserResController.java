package com.onetrillion.trip.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.noUserRes.impl.NoUserResService;

@Controller
@RequestMapping(value = "/noUserRes")
public class NoUserResController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoUserResController.class);
	
	@Autowired
	public NoUserResService service;
	
	//2021. 10. 11 19:35 현성 noUserReservation -회원 예약하기 전체 리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String noUserSelectAll(Model model){
		
		List<NoUserResDTO> noUserResList = service.noUserSelectAll();
		model.addAttribute("noUserResList", noUserResList);
		
		return "noUserRes/list";
	}
	//2021. 10. 11 19:35 현성 noUserReservation -비회원 예약하기 insert 구현
	@RequestMapping(value = "/finished.do", method = RequestMethod.POST)
	@ResponseBody
	public String noUserResInsert(NoUserResDTO dto){
		//System.out.println(dto);
		service.noUserResInsert(dto);
		return null;
	}
	
	
	//2021.10.12 11:00 현성 noUserReservation -비회원 예약하기 detail 구현1
	@RequestMapping(value = "/check.do", method = RequestMethod.GET)
	public String noUserCheck(){
		
		
		return "noUserRes/check";
	}
	
	//2021.10.12 11:00 현성 noUserReservation -비회원 예약하기 detail 구현2
	@RequestMapping(value = "/detail.do", method = RequestMethod.POST)
	public String noUserDetail(@RequestParam("res_name")String res_name, @RequestParam("res_pwd")String res_pwd, 
			HttpServletResponse resp, Model model) throws IOException{
		resp.setContentType("text/html; charset=utf-8");
	    PrintWriter out = resp.getWriter();
		NoUserResDTO dto = new NoUserResDTO();
		dto.setRes_name(res_name);
		dto.setRes_pwd(res_pwd);
		NoUserResDTO result = service.noUserDetail(dto);
		if(result == null) {
			out.println("<script> alert('예약자명 또는 비밀번호가 맞지 않습니다'); ");
			out.println("location.href= 'http://localhost:8088/trip/noUserRes/check.do' </script>");
	        out.close();
	        
		}else 
			model.addAttribute("board", result);
		
		
		return "noUserRes/detail";
	}
	
	
}
