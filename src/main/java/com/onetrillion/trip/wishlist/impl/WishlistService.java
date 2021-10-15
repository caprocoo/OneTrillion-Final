package com.onetrillion.trip.wishlist.impl;


import java.util.List;

import com.onetrillion.trip.wishlist.WishlistDTO;


public interface WishlistService {
	
	// 10/11 15:30 이희연 찜 구현 중
	public void insert_wish(WishlistDTO dto);
	public void delete_wish(int w_seq);
	public List<WishlistDTO> allWishlist(String u_id);
	public List<WishlistDTO> wishListSelectID(String u_id);
	public WishlistDTO wishlistDetail(int w_seq);

}
