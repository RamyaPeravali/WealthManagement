package com.ivy.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivy.project.model.Expense;
import com.ivy.project.repository.ExpenseRepository;

@Service
@Transactional
public class ExpenseService {

	@Autowired
	private ExpenseRepository repo;

	public List<Expense> listAll() {
		return repo.findAll();
	}

	public void save(Expense expense) {
		repo.save(expense);
	}

	public Expense get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}