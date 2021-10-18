package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.page.Criteria;

@Mapper 
public interface OftenMapper { 
	// 자주하는 질문 CRUD   [10/11 한보영] 
	public List<OftenDTO> selectAll_often();
	public List<OftenDTO> oftenPaging(Criteria cri);
	public int oftenCount();
	public OftenDTO detail(int of_seq); 
	public int insert(OftenDTO dto);
	public int delete(OftenDTO dto);
	public int modify(OftenDTO dto);
}
