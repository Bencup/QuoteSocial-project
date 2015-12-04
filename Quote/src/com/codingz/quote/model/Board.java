package com.codingz.quote.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=true)
	private User user;
	
	@Column(name = "detail_post")
	private String detailPost;
	

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categories_id",nullable=true)
	private Categories categories;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creditAuthor_id",nullable=true)
	private CreditAuthor creditAuthor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "statusBoard_id",nullable=true)
	private StatusBoard statusBoard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDetailPost() {
		return detailPost;
	}

	public void setDetailPost(String detailPost) {
		this.detailPost = detailPost;
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

	public StatusBoard getStatusBoard() {
		return statusBoard;
	}

	public void setStatusBoard(StatusBoard statusBoard) {
		this.statusBoard = statusBoard;
	}

	public java.util.Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Calendar createDate) {
		this.createDate = createDate;
	}
	
	
	

}
