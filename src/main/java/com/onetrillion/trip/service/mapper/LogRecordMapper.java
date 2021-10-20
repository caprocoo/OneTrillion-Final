package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.logRecord.LogRecordCriteria;
import com.onetrillion.trip.logRecord.LogRecordDTO;

@Mapper
public interface LogRecordMapper {
	
	public List<LogRecordDTO> logRecordSelectAll();
	public int logRecordInsert(LogRecordDTO dto);
	public List<LogRecordDTO> LogRecordPaging(LogRecordCriteria cri);
	public int LogRecordCount(LogRecordCriteria cri);
}
