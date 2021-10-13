package com.onetrillion.trip.service.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import com.onetrillion.trip.user.UserDTO;
import com.onetrillion.trip.wishlist.WishlistDTO;

public interface WishlistMapper {
	
	// 10/11 15:30 이희연 찜 구현
	public void insert_wish(WishlistDTO dto);
	//public void insert_wish(WishlistDTO dto, @Param("pd_seq") int pd_seq, @Param("u_id") String u_id);
	public WishlistDTO delete_wish(int w_seq);
	public List<WishlistDTO> allWishlist(String u_id);
	public List<WishlistDTO> wishListSelectID(String u_id);


}
