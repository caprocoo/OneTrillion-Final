package com.onetrillion.trip.memo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.memo.MemoDTO;
import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.service.mapper.MemoMapper;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	public MemoMapper memo_mapper;
	
	@Override
	public List<MemoDTO> selectAll(){
		return memo_mapper.selectAll();
	} 
	//디테일
	@Override
	public MemoDTO detail(int memo_seq) {
		return memo_mapper.detail(memo_seq);
	}
	//입력
	@Override
	public int insert(MemoDTO dto) {
		return memo_mapper.insert(dto);
	}
	//수정
	@Override
	public int modify(MemoDTO dto) {
		return memo_mapper.modify(dto);
	}
	
	//삭제
	@Override
	public int delete(MemoDTO dto) {
		return memo_mapper.delete(dto);
	}
	@Override
	public List<MemoDTO> memoPaging(Criteria cri) {
		return memo_mapper.memoPaging(cri);
	}
	@Override
	public int memoCount() {
		return memo_mapper.memoCount();
	}
	
}
