package com.fe.service;

import java.util.List;

import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.ReplyVO;
import com.fe.vo.SearchCriteria;

public interface ReplyService {
	
	public List<ReplyVO> readReply(int fno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
}
