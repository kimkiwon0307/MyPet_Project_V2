package com.fe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.dao.FreeBoardDAO;
import com.fe.dao.ReplyDAO;
import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.ReplyVO;
import com.fe.vo.SearchCriteria;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;

	@Override
	public List<ReplyVO> readReply(int fno) throws Exception {
		return dao.readReply(fno);
	}

	@Override
	public void writeReply(ReplyVO vo) throws Exception {

		dao.writeReply(vo);
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		
		dao.updateReply(vo);
	}

	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		dao.deleteReply(vo);
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		return dao.selectReply(rno);
	}
	

}
