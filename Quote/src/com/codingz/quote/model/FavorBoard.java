package com.codingz.quote.model;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favor_board")
public class FavorBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "board_id",nullable=true)
	private Board board;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=true)
	private User user;
	
	private Boolean statusFavor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getStatusFavor() {
		return statusFavor;
	}

	public void setStatusFavor(Boolean statusFavor) {
		this.statusFavor = statusFavor;
	}
	
		

}
