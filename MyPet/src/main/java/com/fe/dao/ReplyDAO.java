package com.fe.dao;

import java.util.List;

import com.fe.vo.ReplyVO;


public interface ReplyDAO {
	
	
	public List<ReplyVO> readReply(int fno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
	
	
}
