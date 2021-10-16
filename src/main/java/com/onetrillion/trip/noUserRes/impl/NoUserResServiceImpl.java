package com.onetrillion.trip.noUserRes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.page.Criteria;
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
	public NoUserResDTO noUserDetail(String res_email, String res_pwd) {
		return noUserResMapper.noUserDetail(res_email, res_pwd);
	}

	@Override
	public NoUserResDTO noUserSelectId(String res_email) {
		return noUserResMapper.noUserSelectId(res_email);
	}

	@Override
	public List<NoUserResDTO> noUserResPaging(Criteria cri) {
		return noUserResMapper.noUserResPaging(cri);
	}

	@Override
	public int noUserResCount() {
		return noUserResMapper.noUserResCount();
	}

	@Override
	public int noUserResDelete(int res_seq) {
		return noUserResMapper.noUserResDelete(res_seq);
	}

	@Override
	public NoUserResDTO adminNoUserDetail(int res_seq) {
		return noUserResMapper.adminNoUserDetail(res_seq);
	}

	@Override
	public int noUserResModify(NoUserResDTO dto) {
		return noUserResMapper.noUserResModify(dto);
	}





}
