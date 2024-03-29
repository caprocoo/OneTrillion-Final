package com.onetrillion.trip.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.reply.ReplyDTO;
import com.onetrillion.trip.service.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	public ReplyMapper replyMapper;

	@Override
	public List<ReplyDTO> replySelectAll() {
		return replyMapper.replySelectAll();
	}

	@Override
	public int replyInsert(ReplyDTO dto) {
		return replyMapper.replyInsert(dto);
	}

	@Override
	public ReplyDTO replyDetail(int reply_seq) {
		return replyMapper.replyDetail(reply_seq);
	}

	@Override
	public int replyModify(ReplyDTO dto) {
		return replyMapper.replyModify(dto);
	}

	@Override
	public int replyDelete(int reply_seq) {
		return replyMapper.replyDelete(reply_seq);
	}

	@Override
	public List<ReplyDTO> replySelectId(String u_id) {
		return replyMapper.replySelectId(u_id);
	}

	@Override
	public List<ReplyDTO> replyPaging(Criteria cri) {
		return replyMapper.replyPaging(cri);
	}

	@Override
	public int replyCount() {
		return replyMapper.replyCount();
	}

	@Override
	public int replyLikeCountUp(int reply_seq) {
		return replyMapper.replyLikeCountUp(reply_seq);
	}

	@Override
	public List<ReplyDTO> replyPdDetail(int pd_seq) {
		return replyMapper.replyPdDetail(pd_seq);
	}


	
	
	
}
