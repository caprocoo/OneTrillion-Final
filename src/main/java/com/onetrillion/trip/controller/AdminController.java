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
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/admin/adminlogin.do", method = RequestMethod.GET)
	public String AdminLoginPage() {

		return "admin/adminlogin";
	}

	@RequestMapping(value = "/admin/adminlogin.do", method = RequestMethod.POST)
	public String AdminLoginAction(AdminDTO dto, HttpSession session, HttpServletRequest req,HttpServletResponse resp) throws IOException {

		AdminDTO admin = adminService.admin_Login(dto);

		if (admin != null) { //어드민 로그인 되면!
			session.setAttribute("AD_ID", dto.getAD_ID());
			session.setAttribute("admin", admin);
			return "admin/adminMain";
		} else
			resp.setContentType("text/html; charset=UTF-8"); //있으면 리스트로 돌아감
			PrintWriter out = resp.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('관리자가 아닙니다!')");
			out.println("location.href='javascript:history.back();'");
			out.println("</script>");
			out.flush();
			return null;
	}
	
		// 로그아웃 처리
		@RequestMapping(value = "/admin/adminlogout.do", method = RequestMethod.GET)
		public String logout(HttpServletRequest req) {
			HttpSession session = req.getSession();
			session.invalidate();
			return "redirect:../user/login.do";
		}
	

}
