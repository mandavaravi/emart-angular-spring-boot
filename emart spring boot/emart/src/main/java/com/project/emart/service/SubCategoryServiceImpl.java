package com.project.emart.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emart.dao.SubCategoryDao;


@Service
public class SubCategoryServiceImpl implements SubCategoryService{

	@Autowired
	SubCategoryDao subCategoryDao;
	
	

	
}
