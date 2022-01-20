package com.fe.dao;

import java.util.List;

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

	// 목록가져오기
	@Override
	public List<FreeBoardVO> list() throws Exception{
		
		 return sql.selectList("freeboardMapper.list");
	}
	
	// 조회하기
	@Override
	public FreeBoardVO read(int fno) throws Exception {
		return sql.selectOne("freeboardMapper.read", fno);
	}
	
	// 수정하기
	@Override
	public void update(FreeBoardVO vo) throws Exception {
		
		sql.update("freeboardMapper.update", vo);
	}

	
	// 삭제하기
	@Override
	public void delete(int fno) throws Exception {
		
		sql.delete("freeboardMapper.delete", fno);
	}

}
