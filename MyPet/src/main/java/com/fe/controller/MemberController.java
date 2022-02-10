package com.fe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		int result = service.idChk(vo);
		try {
			if(result == 1) {
				return "controller/member/register";
			}else if(result == 0) {
				service.register(vo);
			}
			// 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기 
			// 존재하지 않는다면 -> register
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		MemberVO realPass = service.read(vo);
		MemberVO login = service.login(vo);
		HttpSession session = req.getSession();
		
		//입력한 비밀번호와 저장된 비밀번호 비교
		
		if(vo.getUserPass().equals(realPass.getUserPass()))  {
			System.out.println("hihi");
			session.setAttribute("member", login);
		}else if(vo.getUserPass()!= realPass.getUserPass()){
			
			System.out.println("hihi22");
			rttr.addFlashAttribute("msg", false);
			return "redirect:/";
		}
		
		return "redirect:/freeboard/list";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/memberUpdateView")
	public String registerUpdateView() throws Exception{
		
		System.out.println("hihihihi");
		
		return "member/memberUpdateView";
	}

	@PostMapping("/memberUpdate")
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		
		service.memberUpdate(vo);
		
		session.invalidate();
		
		return "redirect:/";
	}
	
		@GetMapping("/memberDeleteView")
		public String memberDeleteView() throws Exception{
			return "member/memberDeleteView";
		}
		
		@PostMapping("/memberDelete")
		public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
			
			MemberVO member = (MemberVO) session.getAttribute("member");
			String sessionPass = member.getUserPass();
			String voPass = vo.getUserPass();
			
			if(!(sessionPass.equals(voPass))) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:/member/memberDeleteView";
			}
			
			service.memberDelete(vo);
			session.invalidate();
			return "redirect:/";
		}
		
		@ResponseBody
		@PostMapping("/passChk")
		public int passChk(MemberVO vo) throws Exception {
			
			System.out.println("hihi탈퇴");
			return service.passChk(vo);
		}	
		
		@ResponseBody
		@PostMapping("/idChk")
		public int idChk(MemberVO vo) throws Exception {
			return service.idChk(vo);
		}
}