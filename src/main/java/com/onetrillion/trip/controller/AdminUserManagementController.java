package com.onetrillion.trip.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.user.UserDTO;
import com.onetrillion.trip.user.Impl.UserService;

@Controller
@RequestMapping(value="/adminUserManagement")
public class AdminUserManagementController {
	
	@Autowired
	UserService userservice;
	
	
	@RequestMapping(value="/userList", method = RequestMethod.GET)
	public String Admin_userListPage(Model model) {
		
		List<UserDTO> userList = userservice.AlluserList();
		
		model.addAttribute("userList",userList);
		
		
		return "adminUserManagement/adminMem";
	}
	
	@RequestMapping(value="/userInput" , method = RequestMethod.GET)
	public String Admin_userInput() {
		
		return "adminUserManagement/adminMemInput";
	}
	
	@RequestMapping(value="/userInput", method = RequestMethod.POST)
	public String Admin_userInputAct(UserDTO user) {
		userservice.joinUser(user);
		return "redirect:/adminUserManagement/userList";
	}
	
	
	@RequestMapping(value="/userModify" , method = RequestMethod.GET)
	public String Admin_userModify(@RequestParam("u_id") String u_id, Model model) {		
		UserDTO user = userservice.adminReadUser(u_id);
		
		model.addAttribute("user",user);
		return "adminUserManagement/adminMemModi";
	}
	
	@RequestMapping(value="/userModify" , method = RequestMethod.POST)
	public String Admin_userModifyAct(@RequestParam("u_id") String u_id , UserDTO user) {
		
		userservice.modifyUser(user);
		
		return "redirect:/adminUserManagement/userList";
	}
	
	
	
	@RequestMapping(value="/userDelete", method = RequestMethod.POST)
	public String Admin_userDeleteAct(@RequestParam("u_id") String u_id,UserDTO user) {
		try {
			userservice.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/adminUserManagement/userList";
	}
	
	
	
}
