package com.fe.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private int fno;
	private int rno;
	private String content;
	private String writer;
	private Date regdate;
	
}
