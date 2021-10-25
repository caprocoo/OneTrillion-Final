package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;import com.onetrillion.trip.wishlist.WishListCriteria;
import com.onetrillion.trip.wishlist.WishlistDTO;

public interface WishlistMapper {
	
	public void insert_wish(WishlistDTO dto);
	public void delete_wish(int w_seq);
	public List<WishlistDTO> wishListSelectID(String u_id);
	public WishlistDTO wishlistDetail(@Param("u_id") String u_id, @Param("pd_seq") int pd_seq);
	
	// 관리자 =======================================================
	public List<WishlistDTO> admin_allList(); // 관리자 페이지 찜목록 전체출력
	public WishlistDTO admin_delete(int w_seq); // 관리자 페이지 찜 삭제
	public WishlistDTO admin_modiDetail(@Param("w_seq") int w_seq);
	public int admin_modify(WishlistDTO dto);
	public List<WishlistDTO> wishListPaging(WishListCriteria cri);
	public int wishListCount(WishListCriteria cri); 
}
