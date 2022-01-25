package com.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fe.service.AlbumBoardService;
import com.fe.service.FreeBoardService;
import com.fe.vo.AlbumBoardVO;
import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.PageMaker;
import com.fe.vo.SearchCriteria;

@Controller
@RequestMapping("/albumboard/*")
public class AlbumBoardController {
	
	@Autowired
	AlbumBoardService service;
	
	
	// 글쓰기  get
	@GetMapping("/writeView")
	public void writeView() throws Exception{
		
	}
	
	// 글쓰기 post
	@PostMapping("/write")
	public String write(AlbumBoardVO vo) throws Exception{
		
		service.write(vo);
		
		return "redirect:/albumboard/list";
	}

	
}
