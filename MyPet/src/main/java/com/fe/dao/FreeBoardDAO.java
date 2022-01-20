package com.fe.dao;

import java.util.List;

import com.fe.vo.FreeBoardVO;

public interface FreeBoardDAO {
	
	// 글작성
	public void write(FreeBoardVO vo) throws Exception;

	
	// 글 목록가져오기
	public List<FreeBoardVO> list() throws Exception;
	
	// 조회하기
	public FreeBoardVO read(int fno) throws Exception;
	
	// 수정하기
	public void update(FreeBoardVO vo) throws Exception;
	
	// 삭제하기
	public void delete(int fno) throws Exception;
	
}
