package com.onetrillion.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;
import com.onetrillion.trip.user.UserDTO;
import com.onetrillion.trip.user.Impl.UserService;
import com.onetrillion.trip.wishlist.WishlistDTO;
import com.onetrillion.trip.wishlist.impl.WishlistService;

@Controller
@RequestMapping(value = "/adminWishlist")
public class AdminWishlistController {
	
	@Autowired
	public WishlistService service;
	@Autowired
	public BoardService boardService;
	@Autowired
	public UserService userService;

	
	// 전체 리스트 출력
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model) {
		List<WishlistDTO> wishList = service.admin_allList();
		model.addAttribute("wishList", wishList);
		return "adminWishlist/adminWish";
	}
	
	// 입력
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String input() {
		return "adminWishlist/adminWishInput";
	}
	
	// 입력실행
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String input_post(WishlistDTO dto) {
		service.insert_wish(dto); // insert 쿼리문 실행
		return "redirect:./list.do";
	}

	// 수정 페이지 이동
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(@RequestParam("w_seq") int w_seq, Model model) {
		WishlistDTO wishList = service.admin_modiDetail(w_seq);
		model.addAttribute("wishList", wishList);
		return "adminWishlist/adminWishModi";
	}
	
	// 수정실행
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify_post(Model model, WishlistDTO dto) {
		service.admin_modify(dto);
		System.out.println(dto);
		return "redirect:./list.do";
	}
	
	// admin 메인 리스트 출력
	@RequestMapping(value = "/mini.do", method = RequestMethod.GET)
	public String mini(Model model) {
		List<WishlistDTO> wishList = service.admin_allList();
		model.addAttribute("wishList", wishList);
		return "adminWishlist/adminWishMini";
	}
	
	// ajax 삭제
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(int w_seq) {
		service.delete_wish(w_seq);
		return "redirect:/adminWishlist/list.do";
	}
	
	
	// 상품 선택 팝업 창 이동
	@RequestMapping(value = "/popUpPd.do", method = RequestMethod.GET)
	public String popUp_pd(Model model) {
		List<BoardDTO> list = boardService.selectAll();
		model.addAttribute("list",list);
		
		return "adminWishlist/adminWishPopUpPd";
	}
	
	// 회원 선택 팝업 창 이동 
	@RequestMapping(value = "/popUpUser.do", method = RequestMethod.GET)
	public String popUp_user(Model model) {
		List<UserDTO> userList = userService.AlluserList();
		model.addAttribute("userList", userList);
		
		return "adminWishlist/adminWishPopUpUser";
	}
	
	
	
	
	

}
