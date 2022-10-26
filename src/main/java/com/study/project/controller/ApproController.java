package com.study.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;
import com.study.project.service.ApproService;

@Controller
public class ApproController {

	@Resource(name = "service")
	private ApproService approService;
	
	
	
	@RequestMapping("login")
	public String login() {

		return "login";
	}
	
	
	@RequestMapping("loginChk")
	public String loginCheck(@ModelAttribute MemberDTO memberDto, HttpSession session, Model model) {
		int userCnt = approService.userCheck(memberDto.getMemberId());
		int pwCnt = approService.userPwCheck(memberDto);

		if (userCnt == 0) {
			model.addAttribute("userCnt", userCnt);
			System.out.println(userCnt);
			return "login";
		} else if (pwCnt == 0) {
			model.addAttribute("userCnt", userCnt);
			model.addAttribute("pwCnt", pwCnt);
			System.out.println(userCnt +"!"+ pwCnt);
			return "login";
		} else {
			approService.loginChk(memberDto, session);
			model.addAttribute("userCnt", userCnt);
			model.addAttribute("pwCnt", pwCnt);
			return "login";
		}

	}
	
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request ) {
		
			request.getSession().invalidate();
			
		return "redirect:login";
	}
	
	
	@RequestMapping("list")
	public String list(@ModelAttribute BoardDTO boardDto, HttpSession session, Model model) {
		
		if(session.getAttribute("member") == null) {
			return "redirect:login";
		}else {
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			list = approService.list();
			model.addAttribute("list", list);
			model.addAttribute("member");
			System.out.println("////////////" + list);
			
			return "board/list";
		}
	}
	
	
	@RequestMapping("reg")
	public String reg(@ModelAttribute BoardDTO boardDto, HttpSession session, Model model) {
		
		int seq = approService.Seq();
		model.addAttribute("seq", seq);
		model.addAttribute("mode", "add");
		
		return "board/reg";
	}
	
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute BoardDTO boardDto, Model model) {
		
		int insert = approService.insert(boardDto);
		
		if(insert==0) {
			System.out.println(0);
		}else {
			System.out.println(1);
		}

		return "redirect:list";
	}
	
	
	
}
