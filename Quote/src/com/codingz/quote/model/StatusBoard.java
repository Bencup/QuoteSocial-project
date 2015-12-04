package com.codingz.quote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_board")
public class StatusBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "status_board_name")
	private String statusBoardName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusBoardName() {
		return statusBoardName;
	}

	public void setStatusBoardName(String statusBoardName) {
		this.statusBoardName = statusBoardName;
	}

	
	
}
