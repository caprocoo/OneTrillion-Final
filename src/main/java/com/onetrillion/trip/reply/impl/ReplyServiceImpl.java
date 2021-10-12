package com.onetrillion.trip.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.reply.ReplyDTO;
import com.onetrillion.trip.service.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	public ReplyMapper replyMaper;

	@Override
	public List<ReplyDTO> replySelectAll() {
		return replyMaper.replySelectAll();
	}
	
	
	
}
