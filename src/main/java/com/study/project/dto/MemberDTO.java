package com.study.project.dto;

import lombok.Getter;

@Getter
public class MemberDTO {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberRank;


    public void setmemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setmemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setmemberRank(String memberRank) {
        this.memberRank = memberRank;
    }

    @Override
    public String toString() {
    	return "MemberDTO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", memberRank=" + memberRank + "]";
    }
}