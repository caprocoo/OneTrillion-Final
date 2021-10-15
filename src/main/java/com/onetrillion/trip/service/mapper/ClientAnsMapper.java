package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.clientAnswer.ClientAnsDTO;


@Mapper 
public interface ClientAnsMapper {

	//  1:1문의 관리자 답변 CRUD   [10/13 한보영]
	public List<ClientAnsDTO> selectAll();
	public List<ClientAnsDTO> selectOne(int cl_seq); //문의글 seq에 맞는 답변 가져오기
	public ClientAnsDTO detail(int cl_seq ); // 답변글 seq 디테일
	public int insert(ClientAnsDTO dto);
	public int delete(ClientAnsDTO dto);
	public int modify(ClientAnsDTO dto);	
	public int findseq(int cl_seq );	//cl_seq에 맞는 ans_seq를 찾을거야!

	
}
