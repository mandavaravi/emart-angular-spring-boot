package com.project.emart.service;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emart.dao.BuyerDao;
import com.project.emart.entity.BillDetailsEntity;
import com.project.emart.entity.BillEntity;
import com.project.emart.entity.BuyerEntity;
import com.project.emart.entity.CategoryEntity;
import com.project.emart.entity.ItemEntity;
import com.project.emart.entity.SellerEntity;
import com.project.emart.entity.SubCategoryEntity;
import com.project.emart.pojo.BillDetailsPojo;
import com.project.emart.pojo.BillPojo;
import com.project.emart.pojo.BuyerPojo;
import com.project.emart.pojo.CategoryPojo;
import com.project.emart.pojo.ItemPojo;
import com.project.emart.pojo.SellerPojo;
import com.project.emart.pojo.SubCategoryPojo;

@Service
public class BuyerServiceImpl implements BuyerService{
	
	static Logger LOG = Logger.getLogger(BuyerServiceImpl.class.getClass());
	
	@Autowired
	BuyerDao buyerDao;
	
	@Override
	public BuyerPojo validateBuyer(BuyerPojo buyerPojo) {
		
		LOG.info("Entered validateBuyer() service");
		
		BuyerEntity buyerEntity = buyerDao.findByBuyerUsernameAndBuyerPassword(buyerPojo.getBuyerUsername(), buyerPojo.getBuyerPassword());

		if(buyerEntity!=null) {
		Set<BillEntity> allBillsEntity = buyerEntity.getAllBills();
				
		Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
		
		
		for(BillEntity billEntity : allBillsEntity) {
			Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();
			Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
			
			for(BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
				
				ItemEntity itemEntity = billDetailsEntity.getItem();
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
						
				BillDetailsPojo billDetailsPojo = new BillDetailsPojo(billDetailsEntity.getBillDetailsId(), null, itemPojo);
				allBillDetailsPojo.add(billDetailsPojo);
			}
			BillPojo billPojo = new BillPojo(billEntity.getBillId(), 
											 billEntity.getBillType(), 
											 billEntity.getBillDate(), 
											 billEntity.getBillRemarks(), 
											 billEntity.getBillAmount(), 
											 null,
											 allBillDetailsPojo);
			allBillPojo.add(billPojo);
		}
		buyerPojo = new BuyerPojo(buyerEntity.getBuyerId(),
								  buyerEntity.getBuyerUsername(),
								  buyerEntity.getBuyerPassword(),
								  buyerEntity.getBuyerEmail(),
								  buyerEntity.getBuyerMobile(),
								  buyerEntity.getBuyerDate(),
								  allBillPojo);
		}
		BasicConfigurator.configure();
		 LOG.info("Exited validateBuyer() service");
		
		return buyerPojo;
	}

}
