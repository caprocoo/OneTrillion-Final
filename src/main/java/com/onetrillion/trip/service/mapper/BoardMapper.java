package com.onetrillion.trip.service.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.ImageDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> selectAll();
	public BoardDTO detail(int pd_seq);
	public int insert(BoardDTO dto);
	public int delete(BoardDTO dto);
	public int modify(BoardDTO dto);
	public List<BoardDTO> searchData();
	public int cntUp(BoardDTO dto);	 
	public int getCount(BoardDTO dto); 
	public List<BoardDTO> theme(String pd_theme);
	public ImageDTO detailImage(int pd_seq);
	
}