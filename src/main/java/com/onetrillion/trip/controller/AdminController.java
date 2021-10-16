package com.onetrillion.trip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.admin.impl.AdminService;

@Controller
@RequestMapping(value = "/adminLogin")
public class AdminController {

	@Autowired
	AdminService adminService;

	//관리자 로그인 페이지로 이동
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String AdminLoginPage() {
		return "adminLogin/adminlogin";
	}
	//메인페이지로 이동
	@RequestMapping(value = "/adminMain.do", method = RequestMethod.GET)
	public String Admin_main_get()  {
		return "adminLogin/adminMain";	
	}	
	
	@RequestMapping(value = "/adminMain.do", method = RequestMethod.POST)
	public String Admin_main_post(AdminDTO dto, HttpSession session, HttpServletRequest req,HttpServletResponse resp) throws IOException {

		AdminDTO admin = adminService.admin_Login(dto);

		if (admin != null) { //어드민 로그인 되면!
			session.setAttribute("AD_ID", dto.getAD_ID());
			session.setAttribute("admin", admin);
			return "adminLogin/adminMain";			
		} else
			resp.setContentType("text/html; charset=UTF-8"); //있으면 리스트로 돌아감
			PrintWriter out = resp.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('관리자만 로그인 가능합니다!')");
			out.println("location.href='javascript:history.back();'");
			out.println("</script>");
			out.flush();
			return null;
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/"; //메인페이지로 이동
	}
	

}
