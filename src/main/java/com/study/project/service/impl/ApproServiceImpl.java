package com.study.project.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.study.project.dao.ApproDao;
import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;
import com.study.project.service.ApproService;

@Service("service") 
public class ApproServiceImpl implements ApproService{

	
	@Inject
	ApproDao approDao;
	
	@Override
	public int userCheck(String memberId) {
		// TODO Auto-generated method stub
		return  approDao.userCheck(memberId);
	}

	@Override
	public int userPwCheck(MemberDTO dto) {
		// TODO Auto-generated method stub
		return  approDao.userPwCheck(dto);
	}

	@Override
	public MemberDTO loginChk(MemberDTO memberDto, HttpSession session) {
		// TODO Auto-generated method stub
		MemberDTO member = approDao.loginChk(memberDto); 
		if(member != null) { //세션 변수 저장
			session.setAttribute("member", member);
		}
		
		return member;
	}

	@Override
	public int insert(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return approDao.insert(boardDto);
	}

	@Override
	public int Seq() {
		// TODO Auto-generated method stub
		return approDao.seq();
	}

	@Override
	public List<BoardDTO> list(BoardDTO boardDto, HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println(boardDto);
		return approDao.list(boardDto);
	}




}
