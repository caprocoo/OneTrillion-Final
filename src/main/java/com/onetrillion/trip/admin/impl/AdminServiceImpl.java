package com.onetrillion.trip.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.service.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminMapper mapper;

	@Override
	public AdminDTO admin_Login(AdminDTO dto) {
		return mapper.admin_Login(dto);
	}
	//리스트
	@Override
	public List<AdminDTO> selectAll() {
		return mapper.selectAll();
	}
	
	
}
