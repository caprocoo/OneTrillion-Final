package com.onetrillion.trip.board.impl;

import java.util.List;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.ImageDTO;

public interface BoardService {

	List<BoardDTO> selectAll();

	BoardDTO detail(int pd_seq);

	int insert(BoardDTO dto);

	int delete(BoardDTO dto);

	int modify(BoardDTO dto);
	
	List<BoardDTO> searchData();
	
	int cntUp(BoardDTO dto); //========================== 추가 9/10
	
	List<BoardDTO> theme(String pd_theme);

	
	ImageDTO detailImage(int pd_seq);

}