package com.onetrillion.trip.noUserRes.impl;

import java.util.List;


import com.onetrillion.trip.noUserRes.NoUserResDTO;
import com.onetrillion.trip.page.Criteria;

public interface NoUserResService {
	
	int noUserResInsert(NoUserResDTO dto);
	List<NoUserResDTO> noUserSelectAll();
	NoUserResDTO noUserDetail(String res_email, String res_pwd);
	NoUserResDTO noUserSelectId(String res_email);
	NoUserResDTO adminNoUserDetail(int res_seq);
	
	List<NoUserResDTO> noUserResPaging(Criteria cri);
	int noUserResCount();
	int noUserResDelete(int res_seq);
	int noUserResModify(NoUserResDTO dto);
}
