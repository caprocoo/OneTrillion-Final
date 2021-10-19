package com.onetrillion.trip.notice.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.onetrillion.trip.notice.CsnoticeDTO;
import com.onetrillion.trip.page.Criteria;
import com.onetrillion.trip.service.mapper.NoticeMapper;


@Service
public class NoticeServiceImpl implements NoticeService  {
	
	@Autowired
	public NoticeMapper Notice_mapper;
	// 공지사항 CRUD   [10/11 한보영] 
	
	@Override
	public List<CsnoticeDTO> selectAll() {
		return Notice_mapper.selectAll();
	}
	
	@Override
	public CsnoticeDTO detail(int no_seq) {

		return Notice_mapper.detail(no_seq);
	}

	@Override
	public int insert(CsnoticeDTO dto) {

		return Notice_mapper.insert(dto);
	}

	@Override
	public int delete(CsnoticeDTO dto) {

		return Notice_mapper.delete(dto);
	}

	@Override
	public int modify(CsnoticeDTO dto) {

		return Notice_mapper.modify(dto);
	}

	@Override
	public List<CsnoticeDTO> noticePaging(Criteria cri) {
		return Notice_mapper.noticePaging(cri);
	}

	@Override
	public int noticeCount() {
		return Notice_mapper.noticeCount();
	}	
	
	
	
	
	
	
	
	
	
}
