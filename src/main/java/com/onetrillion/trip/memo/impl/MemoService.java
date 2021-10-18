package com.onetrillion.trip.memo.impl;

import java.util.List;

import com.onetrillion.trip.memo.MemoDTO;
import com.onetrillion.trip.page.Criteria;

public interface MemoService {

	List<MemoDTO> selectAll();

	MemoDTO detail(int memo_seq);

	int insert(MemoDTO dto);

	int modify(MemoDTO dto);

	int delete(MemoDTO dto);

	List<MemoDTO> memoPaging(Criteria cri);

	int memoCount();

}