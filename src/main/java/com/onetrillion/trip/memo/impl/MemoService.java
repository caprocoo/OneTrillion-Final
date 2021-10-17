package com.onetrillion.trip.memo.impl;

import java.util.List;

import com.onetrillion.trip.memo.MemoDTO;

public interface MemoService {

	List<MemoDTO> selectAll();

	MemoDTO detail(int memo_seq);

	int insert(MemoDTO dto);

	int modify(MemoDTO dto);

	int delete(MemoDTO dto);

}