package com.onetrillion.trip.wishlist.impl;


import java.util.List;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.service.mapper.WishlistMapper;

import com.onetrillion.trip.wishlist.WishlistDTO;

@Service
public class WishlistServiceImpl implements WishlistService{
	
	@Autowired
	public WishlistMapper mapper;


	// 10/11 15:30 이희연 찜 구현 중
	@Override
	public void insert_wish(WishlistDTO dto) {
		mapper.insert_wish(dto);
	}
	
	@Override
	public void delete_wish(int w_seq) {
		mapper.delete_wish(w_seq);
	}

	@Override
	public List<WishlistDTO> allWishlist(String u_id) {
		return mapper.allWishlist(u_id);
	}

	@Override
	public List<WishlistDTO> wishListSelectID(String u_id) {
		return mapper.wishListSelectID(u_id);
	}

	@Override
	public WishlistDTO wishlistDetail(int pd_seq) {
		return mapper.wishlistDetail(pd_seq);
	}
	
	@Override
	public WishlistDTO wishlistDetail2(String u_id, int pd_seq) {
		return mapper.wishlistDetail2(u_id,pd_seq);
	}



	

	
}
