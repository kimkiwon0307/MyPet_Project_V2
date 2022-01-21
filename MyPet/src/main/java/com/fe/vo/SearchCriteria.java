package com.fe.vo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SearchCriteria extends Criteria{
	
	private String searchType = "";
	private String keyword = "";
	
	

}
