package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.userRes.UserResDTO;

@Mapper
public interface UserResMapper {
	public int userResInsert(UserResDTO dto);
	public List<UserResDTO> userSelectAll();
	public UserResDTO userResDetail(int ures_seq);
	public List<UserResDTO> userSelectId(String u_id);
	
	public List<UserResDTO> userResPaging(Criteria cri);
	public int userResCount();
	public int userResDelete(int ures_seq);
	
}
