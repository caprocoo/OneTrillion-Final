package com.onetrillion.trip.service.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.noUserRes.NoUserResDTO;

@Mapper
public interface NoUserResMapper {
	public int noUserResInsert(NoUserResDTO dto);
}
