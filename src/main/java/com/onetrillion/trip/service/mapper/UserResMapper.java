package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.userRes.UserResDTO;

@Mapper
public interface UserResMapper {
	public int userResInsert(UserResDTO dto);
	public List<UserResDTO> userSelectAll();
}
