package com.ivy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ivy.project.model.Category;
import com.ivy.project.repository.CategoryRepository;
import com.ivy.project.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<Category> listExpenses = categoryRepository.findAll();
		model.addAttribute("listCategories", listExpenses);

		return "categories";
	}

	@RequestMapping("/newCategory")
	public String showNewCategoryPage(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);

		return "new_category";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category) {
		service.save(category);

		return "redirect:/welcome";
	}

	@RequestMapping("/editCategory/{id}")
	public ModelAndView showEditCategoryPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_category");
		Category category = service.get(id);
		mav.addObject("category", category);

		return mav;
	}

	@RequestMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/welcome";
	}
}
