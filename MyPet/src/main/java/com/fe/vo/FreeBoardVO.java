package com.fe.vo;

import java.util.Date;

import lombok.Data;

@Data
public class FreeBoardVO {

	private int fno;
	private String ftitle;
	private String fcontent;
	private String fwriter;
	private Date regdate;
	
	
}
