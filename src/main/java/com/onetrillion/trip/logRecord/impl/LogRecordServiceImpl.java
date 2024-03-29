package com.onetrillion.trip.logRecord.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.logRecord.LogRecordCriteria;
import com.onetrillion.trip.logRecord.LogRecordDTO;

import com.onetrillion.trip.service.mapper.LogRecordMapper;

@Service
public class LogRecordServiceImpl implements LogRecordService {
	
	@Autowired
	LogRecordMapper logRecordMapper;

	@Override
	public List<LogRecordDTO> logRecordSelectAll() {
		return logRecordMapper.logRecordSelectAll();
	}

	@Override
	public int logRecordInsert(LogRecordDTO dto) {
		return logRecordMapper.logRecordInsert(dto);
	}

	@Override
	public List<LogRecordDTO> LogRecordPaging(LogRecordCriteria cri) {
		return logRecordMapper.LogRecordPaging(cri);
	}

	@Override
	public int LogRecordCount(LogRecordCriteria cri) {
		return logRecordMapper.LogRecordCount(cri);
	}
	
	
	
	
	
}
