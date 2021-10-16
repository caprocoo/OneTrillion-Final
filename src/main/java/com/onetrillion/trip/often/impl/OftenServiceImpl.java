package com.onetrillion.trip.often.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.service.mapper.OftenMapper;


@Service
public class OftenServiceImpl implements OftenService   { //10/16 한보영 CRUD끝
	
	
	@Autowired
	public OftenMapper Often_mapper;
	// 자주하는질문   [10/11 한보영] 

	
	
	@Override
	public List<OftenDTO> selectAll_often() { 
		return Often_mapper.selectAll_often();
	}
	
	@Override
	public OftenDTO detail(int pd_seq) {

		return Often_mapper.detail(pd_seq);
	}

	@Override
	public int insert(OftenDTO dto) {

		return Often_mapper.insert(dto);
	}

	@Override
	public int delete(OftenDTO dto) {

		return Often_mapper.delete(dto);
	}

	@Override
	public int modify(OftenDTO dto) {

		return Often_mapper.modify(dto);
	}
	
	
	
	
	
	
}
