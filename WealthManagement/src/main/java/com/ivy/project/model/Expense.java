package com.ivy.project.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "expense")
public class Expense {

	@Id
	private Long id;

	private Date expensedate;

	private String description;

	private String location;

	@ManyToOne
	private Category category;

	@JsonIgnore
	@ManyToOne
	private User user;

	public Expense() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Date expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
