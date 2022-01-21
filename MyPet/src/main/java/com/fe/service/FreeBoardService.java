package com.fe.service;

import java.util.List;

import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.SearchCriteria;

public interface FreeBoardService {
	
	// 글쓰기
	public void write(FreeBoardVO vo) throws Exception;

/**	
	//목록 가져오기
	public List<FreeBoardVO> list() throws Exception;
	
	// 글 목록(페이징) 가져오기
	public List<FreeBoardVO> list(Criteria cri) throws Exception;

	// 게시글 총 갯수
	public int listCount() throws Exception;
*/
	// 글 목록(페이징, 검색) 가져오기
	public List<FreeBoardVO> list(SearchCriteria scri) throws Exception;

	// 게시글 총 갯수(검색)
	public int listCount(SearchCriteria scri) throws Exception; 

	
	
	//조회 하기
	public FreeBoardVO read(int fno) throws Exception;
	
	
	// 수정하기
	public void update(FreeBoardVO vo) throws Exception;
	
	// 삭제하기
	public void delete(int fno) throws Exception;
}
