package com.onetrillion.trip.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
}
