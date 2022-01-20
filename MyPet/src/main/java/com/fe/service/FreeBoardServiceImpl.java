package com.fe.service;

import java.util.List;

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
	
	//목록 가져오기
	@Override
	public List<FreeBoardVO> list() throws Exception {
		
		return dao.list();
	}

	// 조회하기
	@Override
	public FreeBoardVO read(int fno) throws Exception {
		return dao.read(fno);
	}

	@Override
	public void update(FreeBoardVO vo) throws Exception {
		
		dao.update(vo);
	}

	@Override
	public void delete(int fno) throws Exception {
		dao.delete(fno);

	}
}
