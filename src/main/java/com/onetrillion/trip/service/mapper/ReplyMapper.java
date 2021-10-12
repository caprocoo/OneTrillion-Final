package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.reply.ReplyDTO;

@Mapper
public interface ReplyMapper {
	public List<ReplyDTO> replySelectAll();
}
