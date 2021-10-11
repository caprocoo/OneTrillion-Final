package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.CsnoticeDTO;
import com.onetrillion.trip.board.ImageDTO;
import com.onetrillion.trip.board.OftenDTO;

@Mapper 
public interface NoticeMapper { 
	//  공지사항 CRUD   [10/11 한보영] 	
	public List<CsnoticeDTO> selectAll();
	public CsnoticeDTO detail(int no_seq);
	public int insert(CsnoticeDTO dto);

	// 자주하는 질문 CRUD   [10/11 한보영] 
	public List<OftenDTO> selectAll_often();
}
