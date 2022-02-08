package com.fe.dao;

import java.util.List;

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

	@Override
	public List<AlbumBoardVO> list() throws Exception {
		
		return sql.selectList("albumMapper.list"); 
				
	}

	@Override
	public void update(AlbumBoardVO vo) throws Exception {
		
		sql.update("albumMapper.update",vo);
	}

	@Override
	public void delete(int ano) throws Exception {
		
		sql.delete("albumMapper.delete",ano);
	}

	@Override
	public AlbumBoardVO read(int ano) throws Exception {
		return sql.selectOne("albumMapper.read", ano);
	}

	
	
	
}
