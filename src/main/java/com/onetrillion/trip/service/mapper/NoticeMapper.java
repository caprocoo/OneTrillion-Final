package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.often.OftenDTO;

@Mapper 
public interface NoticeMapper { 
	//  공지사항 CRUD   [10/11 한보영] 	
	public List<CsnoticeDTO> selectAll();
	public CsnoticeDTO detail(int no_seq);
	public int insert(CsnoticeDTO dto);

}
