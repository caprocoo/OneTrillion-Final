package com.onetrillion.trip.service.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.community.CommunityDTO;
import com.onetrillion.trip.community.CommunityReplyDTO;


@Mapper
public interface CommunityMapper {
	
	//커뮤니티
	public List<CommunityDTO> selectAll(); //커뮤니티 글 전체 다 가져오기
	public CommunityDTO detail(int com_seq ); //디테일
	public int insert(CommunityDTO dto);
	public int delete(CommunityDTO dto);
	public int modify(CommunityDTO dto);	
	public int cntUp(CommunityDTO dto);	 
	public int getCount(CommunityDTO dto); 
	
	//댓글
	//public int replyInput(CommunityReplyDTO reply_dto);
	//public int replyUpdate(CommunityReplyDTO reply_dto);	

}
