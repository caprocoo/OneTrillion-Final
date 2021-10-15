package com.onetrillion.trip.clientque.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.service.mapper.ClientQueMapper;


@Service
public class ClientqueServiceImpl implements ClientqueService{
	
	@Autowired
	public ClientQueMapper client_mapper;
	// 1:1문의  CRUD   [10/12 한보영] 
	
	//리스트
	@Override
	public List<ClientqueDTO> selectAll() {
		return client_mapper.selectAll();
	}
	//한명만
	@Override
	public List<ClientqueDTO> selectOne(String u_id) {
		return client_mapper.selectOne(u_id);
	}
	//디테일
	@Override
	public ClientqueDTO detail(int cl_seq) {
		return client_mapper.detail(cl_seq);
	}
	//입력
	@Override
	public int insert(ClientqueDTO dto) {
		return client_mapper.insert(dto);
	}
	//수정
	@Override
	public int modify(ClientqueDTO dto) {
		return client_mapper.modify(dto);
	}
	
	//삭제
	@Override
	public int delete(ClientqueDTO dto) {
		return client_mapper.delete(dto);
	}
	
	
	//답변달리면 update
	@Override
	public int getAdminAns(int cl_seq ) {
		return client_mapper.getAdminAns( cl_seq);
	}
	
}
