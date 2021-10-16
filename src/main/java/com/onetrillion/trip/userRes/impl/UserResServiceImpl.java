package com.onetrillion.trip.userRes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.page.Criteria;
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

	@Override
	public List<UserResDTO> userSelectAll() {
		return userResMapper.userSelectAll();
	}

	@Override
	public UserResDTO userResDetail(int ures_seq) {
		return userResMapper.userResDetail(ures_seq);
	}

	@Override
	public List<UserResDTO> userSelectId(String u_id) {
		return userResMapper.userSelectId(u_id);
	}

	@Override
	public List<UserResDTO> userResPaging(Criteria cri) {
		return userResMapper.userResPaging(cri);
	}

	@Override
	public int userResCount() {
		return userResMapper.userResCount();
	}

	@Override
	public int userResDelete(int ures_seq) {
		return userResMapper.userResDelete(ures_seq);
	}

	@Override
	public int userResModify(UserResDTO dto) {
		return userResMapper.userResModify(dto);
	}

}
