package com.fe.service;

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

	
}
