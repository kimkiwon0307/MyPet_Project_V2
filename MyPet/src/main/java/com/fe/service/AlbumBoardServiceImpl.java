package com.fe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.dao.AlbumBoardDAO;
import com.fe.vo.AlbumBoardVO;


@Service
public class AlbumBoardServiceImpl implements AlbumBoardService {

	@Autowired
	private AlbumBoardDAO dao;
	
	@Override
	public void write(AlbumBoardVO vo) throws Exception {
		dao.write(vo);
	}

	@Override
	public List<AlbumBoardVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public void update(AlbumBoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(int ano) throws Exception {
		dao.delete(ano);
	}

	@Override
	public AlbumBoardVO read(int ano) throws Exception {
		return dao.read(ano);
	}

	
}
