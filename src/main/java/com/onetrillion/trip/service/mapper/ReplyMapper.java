package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.reply.ReplyDTO;

@Mapper
public interface ReplyMapper {
	public List<ReplyDTO> replySelectAll();
	public List<ReplyDTO> replyPaging(Criteria cri);
	public int replyCount();
	public int replyInsert(ReplyDTO dto);
	public ReplyDTO replyDetail(int reply_seq);
	public int replyModify(ReplyDTO dto);
	public int replyDelete(int reply_seq);
	public List<ReplyDTO> replySelectId(String u_id);
	
}
