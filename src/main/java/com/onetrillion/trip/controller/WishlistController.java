package com.onetrillion.trip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;


import com.onetrillion.trip.wishlist.WishlistDTO;
import com.onetrillion.trip.wishlist.impl.WishlistService;


@Controller
@RequestMapping(value = "/wishlist")
public class WishlistController {

	// 10/14 이희연 찜 목록 구현 중
	@Autowired
	public WishlistService service;
	@Autowired
	public BoardService boardService;
	  
	// 찜 Ajax
	@RequestMapping(value = "/wishlist.do", method = RequestMethod.GET)
	@ResponseBody
	public String wishlist(Model model, WishlistDTO dto) {
		service.insert_wish(dto); // insert 쿼리문 실행
		return "wishlist/wishlist";
	}
	
	// 찜 목록 출력
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String wishList_page(String u_id, Model model) {
		List<WishlistDTO> wishList = service.wishListSelectID(u_id);
		model.addAttribute("wishList", wishList);
		return "wishlist/list";
	}
	
	// 찜 삭제
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam("w_seq") int w_seq, HttpSession session) {
		service.delete_wish(w_seq);
		String u_id = (String) session.getAttribute("u_id");
		return "redirect:/wishlist/list.do?u_id="+u_id;
	}
	
	


}
