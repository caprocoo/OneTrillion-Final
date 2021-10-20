package com.onetrillion.trip.community.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetrillion.trip.community.CommunityDTO;
import com.onetrillion.trip.community.CommunityReplyDTO;
import com.onetrillion.trip.service.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	public CommunityMapper comu_mapper;
	private SqlSession sqlSession;
	
	@Override
	public List<CommunityDTO> selectAll(){
		return comu_mapper.selectAll();
	}
	@Override
	public CommunityDTO detail(int com_seq) {
		return comu_mapper.detail(com_seq);
	}

	
	@Override
	public int insert(CommunityDTO dto) {
		return comu_mapper.insert(dto);
	}

	
	@Override
	public int delete(CommunityDTO dto) {
		return comu_mapper.delete(dto);
	}

	
	@Override
	public int modify(CommunityDTO dto) {
		return comu_mapper.modify(dto);
	}
	
	@Override	
	public int cntUp(CommunityDTO dto){
		return comu_mapper.cntUp(dto); 
	}
	
	
	//댓글=============================================================	
//	@SuppressWarnings("unlikely-arg-type")
//	@Override	
//    public void replyInsert(CommunityReplyDTO reply_dto) {
//        if (reply_dto.getRe_seq() == 0 || "".equals(reply_dto.getRe_seq())) {
//        	
//        	
//        	if (reply_dto.getParent_seq() != 0) {
//        		CommunityReplyDTO replyInfo = sqlSession.selectOne("selectBoard6ReplyParent", reply_dto.getParent_seq());
//                reply_dto.setRe_depth(replyInfo.getRe_depth());
//                reply_dto.setRe_order(replyInfo.getRe_order() + 1);
//                sqlSession.selectOne("updateBoard6ReplyOrder", replyInfo);
//            } else {
//                Integer reorder = sqlSession.selectOne("selectBoard6ReplyMaxOrder", reply_dto.getCom_seq());
//                reply_dto.setRe_order(reorder);
//            }
//
//
//        	
//        	
//        	
//        	
//        	
//        	
//        	comu_mapper.replyInput(reply_dto);
//        } else {
//        	comu_mapper.replyUpdate(reply_dto);
//        }
//    }

	
	
}
