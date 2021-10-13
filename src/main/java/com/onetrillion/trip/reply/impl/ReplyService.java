package com.onetrillion.trip.reply.impl;

import java.util.List;

import com.onetrillion.trip.reply.ReplyDTO;

public interface ReplyService {
	List<ReplyDTO> replySelectAll();
	int replyInsert(ReplyDTO dto);
	ReplyDTO replyDetail(int reply_seq);
	int replyModify(ReplyDTO dto);
	int replyDelete(int reply_seq);
}
