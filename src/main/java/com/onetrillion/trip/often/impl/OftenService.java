package com.onetrillion.trip.often.impl;

import java.util.List;

import com.onetrillion.trip.often.OftenDTO;

public interface OftenService {

	List<OftenDTO> selectAll_often();

	OftenDTO detail(int of_seq);

	int insert(OftenDTO dto);

	int delete(OftenDTO dto);

	int modify(OftenDTO dto);

}