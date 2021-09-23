package com.ivy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivy.project.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
