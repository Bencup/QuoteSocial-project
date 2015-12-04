package com.codingz.quote.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.codingz.quote.model.Board;
import com.codingz.quote.model.Categories;
import com.codingz.quote.model.CreditAuthor;
import com.codingz.quote.model.User;
import com.codingz.quote.service.creditAuthorService;

public class BoardWithStatusDto {
	
	private String detailBoard;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar createDate;
	
	private String createDate2;
	
	private Long id;	
	private User user;
	private Categories categories;
	private CreditAuthor creditAuthor;
	private Boolean statusFavor;
	public String getDetailBoard() {
		return detailBoard;
	}
	public void setDetailBoard(String detailBoard) {
		this.detailBoard = detailBoard;
	}
	public java.util.Calendar getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Calendar createDate) {
		this.createDate = createDate;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public CreditAuthor getCreditAuthor() {
		return creditAuthor;
	}
	public void setCreditAuthor(CreditAuthor creditAuthor) {
		this.creditAuthor = creditAuthor;
	}
	public Boolean getStatusFavor() {
		return statusFavor;
	}
	public void setStatusFavor(Boolean statusFavor) {
		this.statusFavor = statusFavor;
	}
	public String getCreateDate2() {
		return createDate2;
	}
	public void setCreateDate2(String createDate2) {
		this.createDate2 = createDate2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
