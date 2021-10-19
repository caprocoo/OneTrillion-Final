package com.onetrillion.trip.notice.Impl;

import java.util.List;

import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.page.Criteria;

public interface NoticeService {

	List<CsnoticeDTO> selectAll(); // [공지사항] 리스트
	
	List<CsnoticeDTO> noticePaging(Criteria cri); 
	
	int noticeCount();
	
	CsnoticeDTO detail(int no_seq);

	int insert(CsnoticeDTO dto);

	int delete(CsnoticeDTO dto);

	int modify(CsnoticeDTO dto);

}