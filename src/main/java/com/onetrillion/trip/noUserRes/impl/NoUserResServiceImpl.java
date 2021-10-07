package com.onetrillion.trip.noUserRes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.service.mapper.NoUserResMapper;

@Service
public class NoUserResServiceImpl implements NoUserResService{
	
	@Autowired
	NoUserResMapper noUserResMapper;
	
	@Override
	public int noUserResInsert(NoUserResDTO dto) {
		return noUserResMapper.noUserResInsert(dto);
	}

	@Override
	public List<NoUserResDTO> noUserSelectAll() {
		return noUserResMapper.noUserSelectAll();
	}

}
