package com.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fe.service.FreeBoardService;
import com.fe.vo.Criteria;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.PageMaker;
import com.fe.vo.SearchCriteria;

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
		
		return "redirect:/freeboard/list";
	}
/**	
	 목록가져오기
	@GetMapping("/list")
	public String list(Model model) throws Exception{
		
		model.addAttribute("list", service.list());
		
		return "freeboard/list";
	}
	// 목록가져오기(페이징)
	@GetMapping("/list")
	public String list(Criteria cri, Model model) throws Exception{
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.listCount());
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", service.list(cri));
		
		return "freeboard/list";
	}
 */	
	// 목록가져오기(페이징,검색)
	@GetMapping("/list")
	public String list(@ModelAttribute("scri")SearchCriteria scri, Model model) throws Exception{
		
		PageMaker pm = new PageMaker();
		pm.setCri(scri);
		pm.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", service.list(scri));
		
		return "freeboard/list";
	}
	
	
	// 조회하기
	@GetMapping("/readView")
	public String read(FreeBoardVO vo, Model model) throws Exception{
		
		model.addAttribute("read", service.read(vo.getFno()));
		
		return "freeboard/readView";
	}
	
	// get 수정
	@GetMapping("/updateView")
	public String updateView (FreeBoardVO vo, Model model) throws Exception{
		
		model.addAttribute("update", service.read(vo.getFno()));
		
		return "freeboard/updateView";
		
	}
	
	// post 수정
	@PostMapping("/update")
	public String update(FreeBoardVO vo) throws Exception{
		
		 service.update(vo);
		 
		return "redirect:/freeboard/list";
		
	}
	
	// 삭제
	@PostMapping("/delete")
	public String delete(FreeBoardVO vo) throws Exception{
		
		System.out.println(vo.toString());
		
		service.delete(vo.getFno());
		
		return "redirect:/freeboard/list";
	}
	
	
}
