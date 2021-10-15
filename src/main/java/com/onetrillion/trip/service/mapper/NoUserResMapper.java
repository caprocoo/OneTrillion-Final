package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.page.Criteria;

@Mapper
public interface NoUserResMapper {
	public int noUserResInsert(NoUserResDTO dto);
	public List<NoUserResDTO> noUserSelectAll();
	public NoUserResDTO noUserDetail(@Param("res_email") String res_email, @Param("res_pwd") String res_pwd);
	public NoUserResDTO noUserSelectId(String res_email);
	
	public List<NoUserResDTO> noUserResPaging(Criteria cri);
	public int noUserResCount();
	
	
	
}
