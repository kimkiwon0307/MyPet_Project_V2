package com.fe.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fe.vo.AlbumBoardVO;

public interface AlbumBoardService {
	
 
	public void write(AlbumBoardVO vo, MultipartHttpServletRequest mpRequest) throws Exception;
	
	public List<AlbumBoardVO> list() throws Exception;
	
	public void update(AlbumBoardVO vo) throws Exception;
		
	public void delete(int ano) throws Exception;
	
	public AlbumBoardVO read(int ano) throws Exception;
	
	public List<Map<String, Object>> selectFileList(int ano) throws Exception;
	
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
}
