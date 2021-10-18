package com.onetrillion.trip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onetrillion.trip.board.impl.BoardService;
import com.onetrillion.trip.wishlist.WishlistDTO;
import com.onetrillion.trip.wishlist.impl.WishlistService;

@Controller
@RequestMapping(value = "/wishlist")
public class WishlistController {
	// 10/14 이희연 찜 목록 구현 완료
		@Autowired
		public WishlistService service;
		@Autowired
		public BoardService boardService;
		  
		
		// detail.do 내 찜 Ajax
		@RequestMapping(value = "/wishlist.do", method = RequestMethod.GET)
		@ResponseBody
		public String wishlist(WishlistDTO dto) {
			service.insert_wish(dto); // insert 쿼리문 실행
			return "wishlist/wishlist";
		}
		
		// 찜 목록 출력
		@RequestMapping(value = "/list.do", method = RequestMethod.GET)
		public String wishList_page(HttpSession session, Model model) {
			String u_id = (String) session.getAttribute("u_id");
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
		
		// 체크박스 선택 찜 삭제 ajax
		@RequestMapping(value = "/selectDelete.do", method = RequestMethod.POST)
		public String selectDelete(HttpServletRequest req, HttpSession session, @RequestParam(value="arr[]") List<String> arr) {
			String u_id = (String) session.getAttribute("u_id");
				for(int i=0; i<arr.size(); i++) {
					int arrValue = Integer.parseInt(arr.get(i));
					service.delete_wish(arrValue);
				}
			return "redirect:list.do";
		}	
		
		// search.do 내 찜버튼 ajax
		@RequestMapping(value = "/checkAjax.do", method = RequestMethod.POST)
		@ResponseBody
		public String checkAjax(@RequestParam("pd_seq") int pd_seq, HttpSession session, WishlistDTO dto) {
			String result = "impossible";
			String u_id = (String) session.getAttribute("u_id");
			WishlistDTO wish = service.wishlistDetail2(u_id, pd_seq);

			// DB에 u_id값과 pd_seq가 없으면
			if (wish == null) {
				result = "possible";
				service.insert_wish(dto); //insert
			}
			return result;
		}
		
		
		/*
		 * // search.do 내 찜버튼 색 변경하기...10/16 이희연 현재 미구현!!
		 * @RequestMapping(value = "/checkAjaxColor.do", method = RequestMethod.POST)
		 * 
		 * @ResponseBody public String checkAjaxColor(HttpSession session, WishlistDTO
		 * dto) { System.out.println("checkAjaxColor 왔쌈"); String result = "impossible";
		 * String u_id = (String) session.getAttribute("u_id"); List<WishlistDTO> wish =
		 * service.wishListSelectID(u_id);
		 * 
		 * System.out.println(wish); // DB에 u_id값과 pd_seq가 없으면 if (wish == null) {
		 * result = "possible"; System.out.println("디비에 없삼"); } return result; }
		 */


}
