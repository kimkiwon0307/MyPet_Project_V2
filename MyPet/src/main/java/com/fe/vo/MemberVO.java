package com.fe.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String userId;
	private String userPass;
	private String userName;
	private Date regDate;
	
}
