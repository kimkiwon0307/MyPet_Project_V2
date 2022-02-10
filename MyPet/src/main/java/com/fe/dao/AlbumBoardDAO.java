package com.fe.dao;

import java.util.List;
import java.util.Map;

import com.fe.vo.AlbumBoardVO;

public interface AlbumBoardDAO {
	
 
	public void write(AlbumBoardVO vo) throws Exception;
	
	public List<AlbumBoardVO> list() throws Exception;
	
	public void update(AlbumBoardVO vo) throws Exception;
	
	public void delete(int ano) throws Exception;
	
	public AlbumBoardVO read(int ano) throws Exception;
	
	public void insertFile(Map<String, Object>map) throws Exception;
	
	public List<Map<String, Object>> selectFileList(int ano) throws Exception;
	
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
}
