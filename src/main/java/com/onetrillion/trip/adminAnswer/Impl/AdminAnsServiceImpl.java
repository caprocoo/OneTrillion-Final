package com.onetrillion.trip.adminAnswer.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.adminAnswer.AdminAnsDTO;
import com.onetrillion.trip.service.mapper.AdminAnsMapper;



@Service
public class AdminAnsServiceImpl implements AdminAnsService {
	
	@Autowired
	public AdminAnsMapper adminAns_mapper;
	// 1:1문의 관리자 답변 CRUD   [10/13 한보영] 
	
	//리스트
	@Override
	public List<AdminAnsDTO> selectAll() {
		return adminAns_mapper.selectAll();
	}
	//문의글 seq에 맞는 답변 가져오기
	@Override
	public List<AdminAnsDTO> selectOne(int cl_seq) {
		return adminAns_mapper.selectOne(cl_seq);
	}
	// 답변글 seq 디테일
	@Override
	public AdminAnsDTO detail(int cl_seq) {
		return adminAns_mapper.detail(cl_seq);
	}
	//입력
	@Override
	public int insert(AdminAnsDTO dto) {
		return adminAns_mapper.insert(dto);
	}
	//수정
	@Override
	public int modify(AdminAnsDTO dto) {
		return adminAns_mapper.modify(dto);
	}
	
	//삭제
	@Override
	public int delete(AdminAnsDTO dto) {
		return adminAns_mapper.delete(dto);
	}
	
	
	
	
}
