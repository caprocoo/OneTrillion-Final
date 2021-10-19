package com.onetrillion.trip.community.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.community.CommunityDTO;
import com.onetrillion.trip.service.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	public CommunityMapper comu_mapper;
	
	@Override
	public List<CommunityDTO> selectAll(){
		return comu_mapper.selectAll();
	}
	@Override
	public CommunityDTO detail(int com_seq) {
		return comu_mapper.detail(com_seq);
	}

	
	@Override
	public int insert(CommunityDTO dto) {
		return comu_mapper.insert(dto);
	}

	
	@Override
	public int delete(CommunityDTO dto) {
		return comu_mapper.delete(dto);
	}

	
	@Override
	public int modify(CommunityDTO dto) {
		return comu_mapper.modify(dto);
	}
	
	@Override	
	public int cntUp(CommunityDTO dto){
		return comu_mapper.cntUp(dto); 
	}
	
}
