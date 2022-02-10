package com.fe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fe.dao.AlbumBoardDAO;
import com.fe.util.FileUtils;
import com.fe.vo.AlbumBoardVO;


@Service
public class AlbumBoardServiceImpl implements AlbumBoardService {
	
	@Autowired
	private FileUtils fileUtils;
	
	@Autowired
	private AlbumBoardDAO dao;

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

	@Override
	public void write(AlbumBoardVO vo, MultipartHttpServletRequest mpRequest) throws Exception {
		
		dao.write(vo);
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(vo, mpRequest);
		int size = list.size();
		for(int i=0; i<size; i++) {
			dao.insertFile(list.get(i));
		}
	}

	@Override
	public List<Map<String, Object>> selectFileList(int ano) throws Exception {
		return dao.selectFileList(ano);
	}

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return dao.selectFileInfo(map);
	}

	
}
