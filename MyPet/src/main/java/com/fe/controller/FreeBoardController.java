package com.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fe.service.FreeBoardService;
import com.fe.vo.FreeBoardVO;

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	
	@Autowired
	FreeBoardService service;
	
	
	// 글쓰기  get
	@GetMapping("/writeView")
	public void writeView() throws Exception{
		
	}
	
	// 글쓰기 post
	@PostMapping("/write")
	public String write(FreeBoardVO vo) throws Exception{
		
		service.write(vo);
		
		return "redirect:/";
	}
	
}
