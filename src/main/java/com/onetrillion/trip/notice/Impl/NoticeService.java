package com.onetrillion.trip.notice.Impl;

import java.util.List;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.CsnoticeDTO;
import com.onetrillion.trip.board.OftenDTO;

public interface NoticeService {

	List<CsnoticeDTO> selectAll(); // [공지사항] 리스트

	CsnoticeDTO detail(int no_seq);

	int insert(CsnoticeDTO dto);

	List<OftenDTO> selectAll_often(); //[자주하는 질문] 리스트

}