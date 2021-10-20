package com.onetrillion.trip.komment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.komment.KommentDTO;
import com.onetrillion.trip.service.mapper.KommentMapper;

@Service
public class KommentServiceImpl implements KommentService {
	
	@Autowired
	KommentMapper kommentMapper;
	
	
	
	@Override
	public List<KommentDTO> kommentSelectAll() {
		return kommentMapper.kommentSelectAll();
	}
	@Override
	public int kommentInsert(KommentDTO dto) {
		return kommentMapper.kommentInsert(dto);
	}
	@Override
	public int kommentModify(KommentDTO dto) {
		return kommentMapper.kommentModify(dto);
	}
	@Override
	public int kommentDelete(int kom_seq) {
		return kommentMapper.kommentDelete(kom_seq);
	}
	@Override
	public KommentDTO kommentDetail(int kom_seq) {
		return kommentMapper.kommentDetail(kom_seq);
	}

}
