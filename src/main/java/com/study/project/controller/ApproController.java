package com.study.project.controller;

import javax.annotation.Resource;
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
	public String loginCheck(@ModelAttribute MemberDTO dto, HttpSession session, Model model) {
		int userCnt = approService.userCheck(dto.getMemberId());
		int pwCnt = approService.userPwCheck(dto);

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
			approService.loginChk(dto, session);
			model.addAttribute("userCnt", userCnt);
			model.addAttribute("pwCnt", pwCnt);
			return "login";
		}

	}
	
	@RequestMapping("list")
	public String list() {
		return "board/list";
	}
	
	
	@RequestMapping("reg")
	public String reg(Model model) {
		
		int seq = approService.Seq();
		model.addAttribute("seq", seq);
		
		
		
		return "board/reg";
	}
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute BoardDTO board, Model model) {
		
		int insert = approService.insert(board);
		
		if(insert==0) {
			System.out.println(0);
		}else {
			System.out.println(1);
		}

		return "redirect:list";
	}
	
	
	
}
