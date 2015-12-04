package com.codingz.quote.model;
import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

public class BoardForm {
	
	private Long id;
	
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
