package com.fe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.vo.FreeBoardVO;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO{

	@Autowired
	private SqlSession sql;
	
	// 글쓰기 
	@Override
	public void write(FreeBoardVO vo) throws Exception {
		
		sql.insert("freeboardMapper.insert", vo);

	}

}
