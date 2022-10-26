package com.study.project.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.study.project.dao.ApproDao;
import com.study.project.dto.BoardDTO;
import com.study.project.dto.MemberDTO;

@Repository
public class ApproDaoImpl implements ApproDao{
	
	@Inject
	SqlSession sqlsession;
	
	
	@Override
	public int userCheck(String memberId) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("appro.userCheck", memberId);
	}


	@Override
	public int userPwCheck(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("appro.userPw", dto);
	}


	@Override
	public MemberDTO loginChk(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("appro.loginChk", memberDto);
	}


	@Override
	public int insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return sqlsession.insert("appro.insertBoard", board);
	}


	@Override
	public int seq() {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("appro.seq");
	}


	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return sqlsession.selectList("appro.list");

	}

}
