package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.admin.AdminDTO;

@Mapper
public interface AdminMapper {
	
	public AdminDTO admin_Login(AdminDTO dto);
	public List<AdminDTO> selectAll();
}
