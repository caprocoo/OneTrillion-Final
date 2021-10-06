package com.onetrillion.trip.noUserRes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.service.mapper.NoUserResMapper;

@Service
public class NoUserResImplService implements NoUserResService{
	
	@Autowired
	NoUserResMapper noUserResMapper;
	
	@Override
	public int noUserResInsert(NoUserResDTO dto) {
		return noUserResMapper.noUserResInsert(dto);
	}

}
