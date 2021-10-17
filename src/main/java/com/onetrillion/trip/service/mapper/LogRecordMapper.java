package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.logRecord.LogRecordDTO;
import com.onetrillion.trip.page.Criteria;

@Mapper
public interface LogRecordMapper {
	
	public List<LogRecordDTO> logRecordSelectAll();
	public int logRecordInsert(LogRecordDTO dto);
	public List<LogRecordDTO> LogRecordPaging(Criteria cri);
	public int LogRecordCount();
}
