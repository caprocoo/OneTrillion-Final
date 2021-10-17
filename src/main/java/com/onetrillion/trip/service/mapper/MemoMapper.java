package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.memo.MemoDTO;



@Mapper
public interface MemoMapper {
	public List<MemoDTO> selectAll();
	public MemoDTO detail(int memo_seq );
	public int insert(MemoDTO dto);
	public int delete(MemoDTO dto);
	public int modify(MemoDTO dto);
}
