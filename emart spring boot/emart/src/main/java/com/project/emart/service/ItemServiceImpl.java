package com.project.emart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emart.controller.ItemController;
import com.project.emart.dao.ItemDao;
import com.project.emart.entity.CategoryEntity;
import com.project.emart.entity.ItemEntity;
import com.project.emart.entity.SellerEntity;
import com.project.emart.entity.SubCategoryEntity;
import com.project.emart.pojo.CategoryPojo;
import com.project.emart.pojo.ItemPojo;
import com.project.emart.pojo.SellerPojo;
import com.project.emart.pojo.SubCategoryPojo;

@Service
public class ItemServiceImpl implements ItemService {

	static Logger LOG = Logger.getLogger(ItemServiceImpl.class.getClass());
	
	@Autowired
	ItemDao itemDao;
	
	@Override
	public ItemPojo getItem(int itemId) {
		LOG.info("Entered itemsericeImpl getItem() ");
		
		ItemPojo itemPojo = null;
		Optional result = itemDao.findById(itemId);
		
		if(result.isPresent()) {
			
			//coping the data from entity to pojo
			ItemEntity itemEntity = (ItemEntity) result.get();
			SubCategoryEntity subCategoryEntity = itemEntity.getSubCategory();
			CategoryEntity categoryEntity = subCategoryEntity.getCategory();
			SellerEntity sellerEntity = itemEntity.getSeller(); 
			
			SellerPojo sellerPojo = new SellerPojo(sellerEntity.getSellerId(), 
												   sellerEntity.getSellerUsername(), 
												   sellerEntity.getSellerPassword(), 
												   sellerEntity.getSellerCompany(), 
												   sellerEntity.getSellerBrief(), 
												   sellerEntity.getSellerGst(), 
												   sellerEntity.getSellerAddress(), 
												   sellerEntity.getSellerEmail(), 
												   sellerEntity.getSellerWebsite(), 
												   sellerEntity.getSellerContact());	
			CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(), categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
			SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
												  subCategoryEntity.getSubCategoryName(), 
												  subCategoryEntity.getSubCategoryBrief(), 
												  subCategoryEntity.getSubCategoryGst(), 
												  categoryPojo);
			itemPojo = new ItemPojo(itemEntity.getItemId(),
									itemEntity.getItemName(),
									itemEntity.getItemImage(),
									itemEntity.getItemPrice(),
									itemEntity.getItemDescription(),
									itemEntity.getItemRemarks(),
									itemEntity.getItemStock(),
									sellerPojo,
									subCategoryPojo);
		}
		
		BasicConfigurator.configure();
		LOG.info("Exited itemsericeImpl getItem() ");
		return itemPojo;
		
	}

	@Override
	public List<ItemPojo> getAllItems() {
		LOG.info("Entered itemsericeImpl getAllItems() ");
		
		List<ItemPojo> allItemPojo = new ArrayList<ItemPojo>();
		
		List<ItemEntity> allItemEntity = itemDao.findAll();
		Iterator itr = allItemEntity.iterator();
		
		while(itr.hasNext()) {
			
			ItemEntity itemEntity = (ItemEntity) itr.next();
			SubCategoryEntity subCategoryEntity = itemEntity.getSubCategory();
			CategoryEntity categoryEntity = subCategoryEntity.getCategory();
			SellerEntity sellerEntity = itemEntity.getSeller();
			
			SellerPojo sellerPojo = new SellerPojo(sellerEntity.getSellerId(), 
					   sellerEntity.getSellerUsername(), 
					   sellerEntity.getSellerPassword(), 
					   sellerEntity.getSellerCompany(), 
					   sellerEntity.getSellerBrief(), 
					   sellerEntity.getSellerGst(), 
					   sellerEntity.getSellerAddress(), 
					   sellerEntity.getSellerEmail(), 
					   sellerEntity.getSellerWebsite(), 
					   sellerEntity.getSellerContact());
			CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(), categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
			SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
												  subCategoryEntity.getSubCategoryName(), 
												  subCategoryEntity.getSubCategoryBrief(), 
												  subCategoryEntity.getSubCategoryGst(), 
												  categoryPojo);
			ItemPojo itemPojo = new ItemPojo(itemEntity.getItemId(),
									itemEntity.getItemName(),
									itemEntity.getItemImage(),
									itemEntity.getItemPrice(),
									itemEntity.getItemDescription(),
									itemEntity.getItemRemarks(),
									itemEntity.getItemStock(),
									sellerPojo,
									subCategoryPojo);
			allItemPojo.add(itemPojo);
		}
		
		BasicConfigurator.configure();
		LOG.info("Exited itemsericeImpl getAllItems() ");
		return allItemPojo;
	}

}
