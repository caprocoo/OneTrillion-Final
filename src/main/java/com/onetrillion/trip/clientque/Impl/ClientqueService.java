package com.onetrillion.trip.clientque.Impl;

import java.util.List;

import com.onetrillion.trip.clientque.ClientqueDTO;

public interface ClientqueService {
	//리스트
	List<ClientqueDTO> selectAll();
	//디테일
	ClientqueDTO detail(int cl_seq);
	//입력
	int insert(ClientqueDTO dto);
	

}