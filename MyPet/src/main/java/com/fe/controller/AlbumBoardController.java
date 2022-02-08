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
	
	@GetMapping("/list")
	public String list(Model model) throws Exception{
		
		model.addAttribute("list", service.list());
		
		
		
		return "albumboard/list";
		
	}
	
	// 게시판 수정뷰
	@GetMapping("/updateView")
	public String updateView(AlbumBoardVO vo, Model model) throws Exception{
		
		model.addAttribute("update", service.read(vo.getAno()));
		
		return "album/updateView";
	}
	
	// 게시판 수정
	@PostMapping("/update")
	public String update(AlbumBoardVO vo) throws Exception{
		
		service.update(vo);
		
		return "redirect:/albumboard/list";
	}

	// 게시판 삭제
	@PostMapping("/delete")
	public String delete(AlbumBoardVO vo) throws Exception{
		
		service.delete(vo.getAno());
		
		return "redirect:/albumboard/list";
	}
	
	@GetMapping("/readView")
	public String read(AlbumBoardVO vo, Model model) throws Exception{
		
		model.addAttribute("read", service.read(vo.getAno()));
		
		return "albumboard/readView";
	}

	
}
