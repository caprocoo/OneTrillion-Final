package com.onetrillion.trip.notice.Impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.CsnoticeDTO;
import com.onetrillion.trip.board.OftenDTO;
import com.onetrillion.trip.service.mail.MailUtil;
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
	
	@Override//자주하는질문 
	public List<OftenDTO> selectAll_often() { 
		return Notice_mapper.selectAll_often();
	}
	
	
	
	
	
	
	
	
}
