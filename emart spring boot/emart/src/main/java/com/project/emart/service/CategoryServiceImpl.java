package com.project.emart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emart.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;
	
	
}
