package com.onetrillion.trip.clientque.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
	
	
	
}
