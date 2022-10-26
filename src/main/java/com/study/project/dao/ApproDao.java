package com.study.project.dao;

import java.util.List;

import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;

public interface ApproDao {

	int userCheck(String memberId);

	int userPwCheck(MemberDTO memberDto);

	MemberDTO loginChk(MemberDTO memberDto);

	int insert(BoardDTO boardDto);

	int seq();

	List<BoardDTO> list();

}
