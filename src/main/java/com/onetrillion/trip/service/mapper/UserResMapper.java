package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.userRes.UserResDTO;

@Mapper
public interface UserResMapper {
	public int userResInsert(UserResDTO dto);
	public List<UserResDTO> userSelectAll();
	public UserResDTO userResDetail(int ures_seq);
	public List<UserResDTO> userSelectId(String u_id);
}
