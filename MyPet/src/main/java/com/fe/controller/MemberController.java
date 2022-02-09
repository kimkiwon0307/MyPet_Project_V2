package com.fe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fe.service.MemberService;
import com.fe.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	
	@Autowired
	MemberService service;
	
	// 회원가입 get
	@GetMapping("/register")
	public void getRegister() throws Exception {
	}
	
	// 회원가입 post
	@PostMapping("/register")
	public String postRegister(MemberVO vo) throws Exception {
		
		System.out.println(vo.toString());
		service.register(vo);
		
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		System.out.println(vo.toString());
		
		HttpSession session = req.getSession();
	
		MemberVO login = service.login(vo);
		
		System.out.println(session.toString());
		
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/memberUpdateView")
	public String registerUpdateView() throws Exception{
		
		return "member/memberUpdateView";
	}

	@PostMapping("/memberUpdate")
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		
		service.memberUpdate(vo);
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	// 회원 탈퇴 get
		@RequestMapping(value="/memberDeleteView", method = RequestMethod.GET)
		public String memberDeleteView() throws Exception{
			return "member/memberDeleteView";
		}
		
		// 회원 탈퇴 post
		@RequestMapping(value="/memberDelete", method = RequestMethod.POST)
		public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
			
			// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
			MemberVO member = (MemberVO) session.getAttribute("member");
			// 세션에있는 비밀번호
			String sessionPass = member.getUserPass();
			// vo로 들어오는 비밀번호
			String voPass = vo.getUserPass();
			
			if(!(sessionPass.equals(voPass))) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:/member/memberDeleteView";
			}
			service.memberDelete(vo);
			session.invalidate();
			return "redirect:/";
		}
}