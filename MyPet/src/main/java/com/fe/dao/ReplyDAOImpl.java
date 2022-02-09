package com.fe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.ReplyVO;
import com.fe.vo.SearchCriteria;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Autowired
	private SqlSession sql;

	@Override
	public List<ReplyVO> readReply(int fno) throws Exception {
		return sql.selectList("replyMapper.readReply",fno);
	}

	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		
		sql.insert("replyMapper.writeReply", vo);
		
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		
		sql.update("replyMapper.updateReply", vo);
	}

	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		
		sql.delete("replyMapper.deleteReply", vo);
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		return sql.selectOne("replyMapper.selectReply", rno);
	}
	
	

}
