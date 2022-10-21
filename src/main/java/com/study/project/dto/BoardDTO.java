package com.study.project.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {

	private Integer boardNo;
	private String boardTitle;
	private Date boardRegDate;
	private Date boardSignDate;
	private String boardApprover;
	private String boardSignStatus;
	private String memberId;
	private String boardContent;
	
	private MemberDTO memberDTO;
	
}
