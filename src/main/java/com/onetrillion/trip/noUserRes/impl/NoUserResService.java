package com.onetrillion.trip.noUserRes.impl;

import java.util.List;

import com.onetrillion.trip.noUserRes.NoUserResDTO;

public interface NoUserResService {
	
	int noUserResInsert(NoUserResDTO dto);
	List<NoUserResDTO> noUserSelectAll();
	
	
}
