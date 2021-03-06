package com.fe.dao;

import com.fe.vo.FreeBoardVO;
import com.fe.vo.MemberVO;


public interface MemberDAO {
	
	public void register(MemberVO vo) throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public void memberUpdate(MemberVO vo)throws Exception;
	
	public void memberDelete(MemberVO vo)throws Exception;
	
	public MemberVO read(MemberVO vo) throws Exception;
	
	public int passChk(MemberVO vo) throws Exception;
	
	public int idChk(MemberVO vo) throws Exception;
}
