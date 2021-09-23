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

import com.ivy.project.model.Expense;
import com.ivy.project.repository.ExpenseRepository;
import com.ivy.project.service.ExpenseService;


@Controller
public class ExpenseController {

	@Autowired
    private ExpenseService service;
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@GetMapping("/welcome")
	public String listExpenses(Model model) {
		List<Expense> listExpenses = expenseRepository.findAll();
		model.addAttribute("listExpenses",listExpenses);
		
		return "welcome";
	}

	@RequestMapping("/new")
	public String showNewExpensePage(Model model) {
	    Expense expense = new Expense();
	    model.addAttribute("expense", expense);
	     
	    return "new_expense";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
	    service.save(expense);
	     
	    return "redirect:/welcome";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditExpensePage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_expense");
	    Expense expense = service.get(id);
	    mav.addObject("expense", expense);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteExpense(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/welcome";       
	}
	
}