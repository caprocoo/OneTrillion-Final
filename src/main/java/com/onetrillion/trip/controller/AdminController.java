package com.onetrillion.trip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.admin.impl.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/admin/adminlogin.do", method = RequestMethod.GET)
	public String AdminLoginPage() {

		return "admin/adminlogin";
	}

	@RequestMapping(value = "/admin/adminlogin.do", method = RequestMethod.POST)
	public String AdminLoginAction(AdminDTO dto, HttpSession session, HttpServletRequest req) {

		AdminDTO admin = adminService.admin_Login(dto);

		if (admin != null) {
			session.setAttribute("AD_ID", dto.getAD_ID());
			session.setAttribute("admin", admin);
			return "redirect:../board/mainPage.do";
		} else
			// 로그인 실패시
		return "redirect:adminlogin.do";
	}
	
		// 로그아웃 처리

		@RequestMapping(value = "/admin/adminlogout.do", method = RequestMethod.GET)
		public String logout(HttpServletRequest req) {
			HttpSession session = req.getSession();
			session.invalidate();
			//System.out.println("들어옴ㅎ");
			return "redirect:../user/login.do";
		}
	

}
