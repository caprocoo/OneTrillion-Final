package com.onetrillion.trip.noUserRes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.service.mapper.NoUserResMapper;
import com.onetrillion.trip.userRes.UserResDTO;

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

	@Override
	public NoUserResDTO noUserDetail(NoUserResDTO dto) {
		return noUserResMapper.noUserDetail(dto);
	}


}
