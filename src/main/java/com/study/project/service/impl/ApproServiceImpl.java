package com.study.project.service.impl;

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
	public MemberDTO loginChk(MemberDTO dto, HttpSession session) {
		// TODO Auto-generated method stub
		MemberDTO member = approDao.loginChk(dto); 
		if(member != null) { //세션 변수 저장
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			session.setAttribute("memberRank", member.getMemberRank());
		}
		
		return member;
	}

	@Override
	public int insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return approDao.insert(board);
	}

	@Override
	public int Seq() {
		// TODO Auto-generated method stub
		return approDao.seq();
	}



}
