package com.onetrillion.trip.notice.Impl;

import java.util.List;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.often.OftenDTO;

public interface NoticeService {

	List<CsnoticeDTO> selectAll(); // [공지사항] 리스트

	CsnoticeDTO detail(int no_seq);

	int insert(CsnoticeDTO dto);

}