package com.onetrillion.trip.community.impl;

import java.util.List;

import com.onetrillion.trip.community.CommunityDTO;
import com.onetrillion.trip.community.CommunityReplyDTO;

public interface CommunityService {

	List<CommunityDTO> selectAll();

	CommunityDTO detail(int com_seq);

	int insert(CommunityDTO dto);

	int delete(CommunityDTO dto);

	int modify(CommunityDTO dto);

	int cntUp(CommunityDTO dto);

	//void replyInsert(CommunityReplyDTO reply_dto);
	

}