package com.onetrillion.trip.noUserRes.impl;

import java.util.List;

import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.userRes.UserResDTO;

public interface NoUserResService {
	
	int noUserResInsert(NoUserResDTO dto);
	List<NoUserResDTO> noUserSelectAll();
	NoUserResDTO noUserDetail(String res_email, String res_pwd);
	NoUserResDTO noUserSelectId(String res_email);
	
	List<NoUserResDTO> noUserResPaging(Criteria cri);
	int noUserResCount();
}
