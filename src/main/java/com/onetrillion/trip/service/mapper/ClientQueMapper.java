package com.onetrillion.trip.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onetrillion.trip.clientque.ClientqueDTO;
import com.onetrillion.trip.page.Criteria;

@Mapper 
public interface ClientQueMapper {

	//  1:1문의  CRUD   [10/12 한보영]
	public List<ClientqueDTO> selectAll();
	public List<ClientqueDTO> clientquePaging(Criteria cri);
	public int clientqueCount();
	public List<ClientqueDTO> selectOne(String u_id);
	public ClientqueDTO detail(int cl_seq );
	public int insert(ClientqueDTO dto);
	public int delete(ClientqueDTO dto);
	public int modify(ClientqueDTO dto);
	public int getAdminAns(int cl_seq); //10/15
	
	
	
}
