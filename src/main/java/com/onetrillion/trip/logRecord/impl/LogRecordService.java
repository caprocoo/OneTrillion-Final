package com.onetrillion.trip.logRecord.impl;

import java.util.List;

import com.onetrillion.trip.logRecord.LogRecordCriteria;
import com.onetrillion.trip.logRecord.LogRecordDTO;


public interface LogRecordService {
	
	List<LogRecordDTO> logRecordSelectAll();
	List<LogRecordDTO> LogRecordPaging(LogRecordCriteria cri);
	int logRecordInsert(LogRecordDTO dto);
	int LogRecordCount(LogRecordCriteria cri);
	
}