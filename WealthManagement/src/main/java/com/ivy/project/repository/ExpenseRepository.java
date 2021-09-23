package com.ivy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivy.project.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
	
}
