package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.admin.AdminDTO;
import com.onetrillion.trip.adminAnswer.AdminAnsDTO;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.clientque.ClientqueDTO;

@Mapper 
public interface AdminAnsMapper {

	//  1:1문의 관리자 답변 CRUD   [10/13 한보영]
	public List<AdminAnsDTO> selectAll();
	public List<AdminAnsDTO> selectOne(int cl_seq); //문의글 seq에 맞는 답변 가져오기
	public AdminAnsDTO detail(int cl_seq ); // 답변글 seq 디테일
	public int insert(AdminAnsDTO dto);
	public int delete(AdminAnsDTO dto);
	public int modify(AdminAnsDTO dto);	
	public int findseq(int cl_seq );	//cl_seq에 맞는 ans_seq를 찾을거야!

	
}
