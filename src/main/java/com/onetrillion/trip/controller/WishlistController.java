package com.onetrillion.trip.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;


import com.onetrillion.trip.wishlist.WishlistDTO;
import com.onetrillion.trip.wishlist.impl.WishlistService;


@Controller
@RequestMapping(value = "/wishlist")
public class WishlistController {
	private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);

	@Autowired
	public WishlistService service;
	
	@Autowired
	public BoardService boardService;
	  
	
	// 10.11 12:00 이희연 wishlist 구현 중
	@RequestMapping(value = "/wishlist.do", method = RequestMethod.GET)
	@ResponseBody
	public String wishlist_page(Model model, WishlistDTO dto) {
		// dto 담은 데이터 insert 쿼리문 실행
		service.insert_wish(dto);
		
		
		return "wishlist/wishlist";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String total_wishList_page(String u_id, Model model) {
		
		List<WishlistDTO> wishList = service.wishListSelectID(u_id);
		model.addAttribute("wishList", wishList);
		
		return "wishlist/list";
	}

	//관리자가 상품 삭제 완료(Ajax)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public void deletePost(WishlistDTO dto) {
		service.delete_wish(dto);
		
	}
	

	


}
