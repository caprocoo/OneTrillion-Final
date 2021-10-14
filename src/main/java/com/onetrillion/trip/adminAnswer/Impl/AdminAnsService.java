package com.onetrillion.trip.adminAnswer.Impl;

import java.util.List;

import com.onetrillion.trip.adminAnswer.AdminAnsDTO;

public interface AdminAnsService {
	// 1:1문의 관리자 답변 CRUD   [10/13 한보영] 

	//리스트
	List<AdminAnsDTO> selectAll();

	//문의글 seq에 맞는 답변 가져오기
	List<AdminAnsDTO> selectOne(int cl_seq);

	// 답변글 seq 디테일
	AdminAnsDTO detail(int cl_seq);

	//입력
	int insert(AdminAnsDTO dto);

	//수정
	int modify(AdminAnsDTO dto);

	//삭제
	int delete(AdminAnsDTO dto);

	//seq찾기
	int findseq(int cl_seq);

}