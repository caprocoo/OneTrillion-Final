package com.onetrillion.trip.wishlist.impl;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.onetrillion.trip.wishlist.WishlistDTO;


public interface WishlistService {
	
	// 10/11 15:30 이희연 찜 구현
	public void insert_wish(WishlistDTO dto);
	public void delete_wish(int w_seq);
	public List<WishlistDTO> wishListSelectID(String u_id);
	public WishlistDTO wishlistDetail(@Param("u_id") String u_id, @Param("pd_seq") int pd_seq);
	
	// 관리자 =======================================================
	public List<WishlistDTO> admin_allList(); // 관리자 페이지 찜목록 전체출력
	public WishlistDTO admin_delete(int w_seq);
	public WishlistDTO admin_modiDetail(@Param("w_seq") int w_seq); // 수정창으로 이동
	public int admin_modify(WishlistDTO dto); // 수정 실행
	
}
