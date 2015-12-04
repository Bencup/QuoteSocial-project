package com.codingz.quote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "categories_name")
	private String categoriesName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}
	
	
}
