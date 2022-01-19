package com.fe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.dao.FreeBoardDAO;
import com.fe.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO dao;
	
	// 글쓰기 
	@Override
	public void write(FreeBoardVO vo) throws Exception {
		dao.write(vo);
	}

}
