package com.fe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.MemberVO;
import com.fe.vo.ReplyVO;
import com.fe.vo.SearchCriteria;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sql;

	@Override
	public void register(MemberVO vo) throws Exception {
		
		sql.insert("memberMapper.register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne("memberMapper.login", vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
			
		sql.update("memberMapper.memberUpdate", vo);
	}

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		
		sql.delete("memberMapper.memberDelete", vo);
	}
	

}
