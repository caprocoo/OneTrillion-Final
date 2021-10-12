package com.onetrillion.trip.often.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


import com.onetrillion.trip.often.OftenDTO;
import com.onetrillion.trip.service.mail.MailUtil;
import com.onetrillion.trip.service.mapper.NoticeMapper;


@Service
public class OftenServiceImpl implements OftenService   {
	
	
	@Autowired
	public NoticeMapper Notice_mapper;
	// 자주하는질문   [10/11 한보영] 

	
	
	@Override
	public List<OftenDTO> selectAll_often() { 
		return Notice_mapper.selectAll_often();
	}
	
	
	
	
	
	
	
	
}
