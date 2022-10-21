package com.study.project.dao;

import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;

public interface ApproDao {

	int userCheck(String memberId);

	int userPwCheck(MemberDTO dto);

	MemberDTO loginChk(MemberDTO dto);

	int insert(BoardDTO board);

	int seq();

}
