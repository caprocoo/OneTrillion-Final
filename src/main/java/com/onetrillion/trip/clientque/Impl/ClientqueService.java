package com.onetrillion.trip.clientque.Impl;

import java.util.List;

import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.page.Criteria;

public interface ClientqueService {
	//리스트
	List<ClientqueDTO> selectAll();
	//한명만
	List<ClientqueDTO> selectOne(String u_id);
	//디테일
	ClientqueDTO detail(int cl_seq);
	//입력
	int insert(ClientqueDTO dto);
	//수정
	int modify(ClientqueDTO dto);
	//삭제
	int delete(ClientqueDTO dto);
	//답변달리면 update
	int getAdminAns(int cl_seq );

	List<ClientqueDTO> clientquePaging(Criteria cri);
	
	int clientqueCount();
	

}