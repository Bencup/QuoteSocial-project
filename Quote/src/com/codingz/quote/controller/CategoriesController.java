package com.codingz.quote.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.quote.iservice.ICategoriesService;
import com.codingz.quote.model.Categories;

@Controller
public class CategoriesController {
	
	@Autowired
	private ICategoriesService categoriesService;
	
	@RequestMapping(value = "/categories.html")
	public ModelAndView index() {
		
		try {
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("categories");
			
			List<Categories> categoriesList = new ArrayList<Categories>(categoriesService.findAll());
			mav.addObject("categoriesList", categoriesList);
			System.out.println("cate==="+categoriesList.get(0));
			
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
