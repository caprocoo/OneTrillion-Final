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

import com.onetrillion.trip.board.impl.BoardService;


import com.onetrillion.trip.wishlist.WishlistDTO;
import com.onetrillion.trip.wishlist.impl.WishlistService;


@Controller
@RequestMapping(value = "/wishlist")
public class WishlistController {
	private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);

//	@Autowired
//	public UserService userService;
	
	@Autowired
	public WishlistService service;
	
	@Autowired
	public BoardService boardService;
	  
	
//	// 10.11 12:00 이희연 wishlist 구현 중
//	//@ResponseBody
//	@RequestMapping(value = "/wishlist.do", method = RequestMethod.GET)
//	public String wishlist_page(
//			@RequestParam("pd_seq") int pd_seq, 
//			@RequestParam("u_id") String u_id, 
//			Model model) {
//		
//		BoardDTO boardDto = boardService.detail(pd_seq); // pd_seq를 이용해 해당 row값 다 가져오고, boardDto에 대입시켜줌
//		//UserDTO userDto = userService.oneUser_id(u_id);
//		
//		// 가져온 boardDto에 있는 데이터 뽑아내기
//		String pd_name = boardDto.getPd_name();
//		LocalDate pd_startDate = boardDto.getPd_startDate();
//		LocalDate pd_endDate = boardDto.getPd_endDate();
//		String pd_image = boardDto.getPd_image();
//		int pd_price = boardDto.getPd_price();
//		
//		// 뽑아온 데이터들을 WishlistDTO에 담아주기
//		WishlistDTO dto = new WishlistDTO();
//		dto.setPd_seq(pd_seq);
//		dto.setPd_startDate(pd_startDate);
//		dto.setPd_endDate(pd_endDate);
//		dto.setPd_name(pd_name);
//		dto.setPd_price(pd_price);
//		dto.setPd_image(pd_image);
//		dto.setU_id(u_id);
//		
//		// dto에 담은 데이터 확인
//		System.out.println("wishlistController 들어왔당 ~~~ "+ dto.toString());
//		
//		// dto 담은 데이터 insert 쿼리문 실행
//		service.insert_wish(dto);
//		
//		return "wishlist/wishlist";
//	}
	
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

//	@RequestMapping(value = "/wishlist.do", method = RequestMethod.GET)
//	public String wishlist_view(Model model, String u_id) {
//		List<WishlistDTO> list = service.allWishlist(u_id);
//		model.addAttribute("list",list);
//		
//		return "wishlist/wishlist";
//	}
	
	
//
//	@RequestMapping(value = "/user/wishlist")
//	public String wishlist() {
//
//		return "wishlist/wishlist";
//	}

	


}
