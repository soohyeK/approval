package com.study.project.service;

import javax.servlet.http.HttpSession;

import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;

public interface ApproService {

	int userCheck(String memberId);

	int userPwCheck(MemberDTO dto);

	MemberDTO loginChk(MemberDTO dto, HttpSession session);

	int insert(BoardDTO board);

	int Seq();


}
