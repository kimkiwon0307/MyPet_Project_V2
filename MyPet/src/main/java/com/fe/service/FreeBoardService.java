package com.fe.service;

import java.util.List;

import com.fe.vo.FreeBoardVO;

public interface FreeBoardService {
	
	// 글쓰기
	public void write(FreeBoardVO vo) throws Exception;

	
	//목록 가져오기
	public List<FreeBoardVO> list() throws Exception;
	
	//조회 하기
	public FreeBoardVO read(int fno) throws Exception;
	
	
	// 수정하기
	public void update(FreeBoardVO vo) throws Exception;
	
	// 삭제하기
	public void delete(int fno) throws Exception;
}
