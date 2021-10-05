package com.onetrillion.trip.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.ImageDTO;
import com.onetrillion.trip.service.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardDTO> selectAll() {
		return boardMapper.selectAll();
	}

	@Override
	public BoardDTO detail(int pd_seq) {

		return boardMapper.detail(pd_seq);
	}

	@Override
	public int insert(BoardDTO dto) {

		return boardMapper.insert(dto);
	}

	@Override
	public int delete(BoardDTO dto) {

		return boardMapper.delete(dto);
	}

	@Override
	public int modify(BoardDTO dto) {

		return boardMapper.modify(dto);
	}

	@Override
	public List<BoardDTO> searchData() {
		
		return boardMapper.searchData();
	}
	
	@Override
	public int cntUp(BoardDTO dto){
		return boardMapper.cntUp(dto); 
	}

	@Override
	public List<BoardDTO> theme(String pd_theme) {
		
		return boardMapper.theme(pd_theme);
	}



	@Override
	public ImageDTO detailImage(int pd_seq) {
		
		return boardMapper.detailImage(pd_seq);
	};
	

}
