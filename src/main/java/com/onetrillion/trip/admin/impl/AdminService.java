package com.onetrillion.trip.admin.impl;

import java.util.List;

import com.onetrillion.trip.admin.AdminDTO;

public interface AdminService {
	
	public AdminDTO admin_Login(AdminDTO dto);

	List<AdminDTO> selectAll();
}
