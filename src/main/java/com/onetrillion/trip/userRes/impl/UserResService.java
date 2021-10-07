package com.onetrillion.trip.userRes.impl;

import java.util.List;

import com.onetrillion.trip.userRes.UserResDTO;

public interface UserResService {
	
	int userResInsert(UserResDTO dto);
	List<UserResDTO> userSelectAll();
	
}
