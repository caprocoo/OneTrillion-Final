package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.komment.KommentDTO;

@Mapper
public interface KommentMapper {
	
	List<KommentDTO> kommentSelectAll();
	
	int kommentInsert(KommentDTO dto);
	int kommentModify(KommentDTO dto);
	int kommentDelete(int kom_seq);
	KommentDTO kommentDetail(int kom_seq);
	
}
