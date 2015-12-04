package com.codingz.quote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credit_author")
public class CreditAuthor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "credit_author_name")
	private String creditAuthorName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreditAuthorName() {
		return creditAuthorName;
	}

	public void setCreditAuthorName(String creditAuthorName) {
		this.creditAuthorName = creditAuthorName;
	}

	
}
