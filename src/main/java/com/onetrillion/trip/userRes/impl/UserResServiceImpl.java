package com.onetrillion.trip.userRes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.service.mapper.UserResMapper;
import com.onetrillion.trip.userRes.UserResDTO;

@Service
public class UserResServiceImpl implements UserResService{
	
	@Autowired
	UserResMapper userResMapper;
	
	@Override
	public int userResInsert(UserResDTO dto) {
		return userResMapper.userResInsert(dto);
	}

}
