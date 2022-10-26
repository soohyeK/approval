package com.study.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;

public interface ApproService {

	int userCheck(String memberId);

	int userPwCheck(MemberDTO dto);

	MemberDTO loginChk(MemberDTO memberDto, HttpSession session);

	int insert(BoardDTO board);

	int Seq();

	List<BoardDTO> list();


}
