package com.fe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fe.service.FreeBoardService;
import com.fe.service.ReplyService;
import com.fe.vo.FreeBoardVO;
import com.fe.vo.PageMaker;
import com.fe.vo.ReplyVO;
import com.fe.vo.SearchCriteria;

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	
	@Autowired
	FreeBoardService service;
	
	@Autowired
	ReplyService replyService;
	
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
	public String read(FreeBoardVO vo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		model.addAttribute("read", service.read(vo.getFno()));
		model.addAttribute("scri",scri);
		
		List<ReplyVO> replyList = replyService.readReply(vo.getFno());
		model.addAttribute("replyList", replyList);
		
		
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
	
	//댓글 작성
		@PostMapping("/replyWrite")
		public String replyWrite(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			replyService.writeReply(vo);
			
			rttr.addAttribute("fno", vo.getFno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/freeboard/readView";
		}
		
		//댓글 수정 GET
		@GetMapping("/replyUpdateView")
		public String replyUpdateView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
			
			model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			
			return "freeboard/replyUpdateView";
		}
		
		//댓글 수정 POST
		@PostMapping("/replyUpdate")
		public String replyUpdate(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			replyService.updateReply(vo);
			
			rttr.addAttribute("fno", vo.getFno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/freeboard/readView";
		}	
	
		//댓글 삭제 GET
		@GetMapping("/replyDeleteView")
		public String replyDeleteView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
			
			model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);

			return "freeboard/replyDeleteView";
		}
		
		//댓글 삭제
		@PostMapping("/replyDelete")
		public String replyDelete(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			replyService.deleteReply(vo);
			
			rttr.addAttribute("fno", vo.getFno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/freeboard/readView";
		}
		
	
	
}
