package com.onetrillion.trip.clientAnswer.Impl;

import java.util.List;

import com.onetrillion.trip.clientAnswer.ClientAnsDTO;

public interface ClientAnsService {
	// 1:1문의 관리자 답변 CRUD   [10/13 한보영] 

	//리스트
	List<ClientAnsDTO> selectAll();

	//문의글 seq에 맞는 답변 가져오기
	List<ClientAnsDTO> selectOne(int cl_seq);

	// 답변글 seq 디테일
	ClientAnsDTO detail(int cl_seq);

	//입력
	int insert(ClientAnsDTO dto);

	//수정
	int modify(ClientAnsDTO dto);

	//삭제
	int delete(ClientAnsDTO dto);

	//seq찾기
	int findseq(int cl_seq);

}