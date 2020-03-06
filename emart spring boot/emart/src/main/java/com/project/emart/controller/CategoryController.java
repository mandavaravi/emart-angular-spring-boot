package com.project.emart.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.emart.service.CategoryService;

@RestController
@RequestMapping("emart")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	

}
