package com.fe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.vo.AlbumBoardVO;

@Repository
public class AlbumBoardDAOImpl implements AlbumBoardDAO {

	@Autowired
	private SqlSession sql;
	
	@Override
	public void write(AlbumBoardVO vo) throws Exception {
		
		sql.insert("albumMapper.insert", vo);
	}

	
	
	
}
