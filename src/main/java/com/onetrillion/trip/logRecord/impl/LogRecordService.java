package com.onetrillion.trip.logRecord.impl;

import java.util.List;

import com.onetrillion.trip.logRecord.LogRecordDTO;
import com.onetrillion.trip.page.Criteria;

public interface LogRecordService {
	
	List<LogRecordDTO> logRecordSelectAll();
	List<LogRecordDTO> LogRecordPaging(Criteria cri);
	int logRecordInsert(LogRecordDTO dto);
	int LogRecordCount();
	
}