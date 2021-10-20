package com.onetrillion.trip.komment.impl;

import java.util.List;

import com.onetrillion.trip.komment.KommentDTO;

public interface KommentService {
	
	public List<KommentDTO> kommentSelectAll();
	public int kommentInsert(KommentDTO dto);
	public int kommentModify(KommentDTO dto);
	public int kommentDelete(int kom_seq);
	public KommentDTO kommentDetail(int kom_seq);
	
}