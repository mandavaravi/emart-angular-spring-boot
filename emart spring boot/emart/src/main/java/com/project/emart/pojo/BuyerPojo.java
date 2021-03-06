package com.project.emart.pojo;

import java.util.Date;
import java.util.Set;

public class BuyerPojo {
	
	int buyerId;
	String buyerUsername;
	String buyerPassword;
	String buyerEmail;
	int buyerMobile;
	Date buyerDate;
	Set<BillPojo> allBills;
	
	public BuyerPojo() {
		super();
	}

	

	public BuyerPojo(int buyerId, String buyerUsername, String buyerPassword, String buyerEmail, int buyerMobile,
			Date buyerDate, Set<BillPojo> allBills) {
		super();
		this.buyerId = buyerId;
		this.buyerUsername = buyerUsername;
		this.buyerPassword = buyerPassword;
		this.buyerEmail = buyerEmail;
		this.buyerMobile = buyerMobile;
		this.buyerDate = buyerDate;
		this.allBills = allBills;
	}



	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerUsername() {
		return buyerUsername;
	}

	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}

	public String getBuyerPassword() {
		return buyerPassword;
	}

	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public int getBuyerMobile() {
		return buyerMobile;
	}

	public void setBuyerMobile(int buyerMobile) {
		this.buyerMobile = buyerMobile;
	}

	public Date getBuyerDate() {
		return buyerDate;
	}

	public void setBuyerDate(Date buyerDate) {
		this.buyerDate = buyerDate;
	}
	
	public Set<BillPojo> getAllBills() {
		return allBills;
	}

	public void setAllBills(Set<BillPojo> allBills) {
		this.allBills = allBills;
	}

	@Override
	public String toString() {
		return "BuyerPojo [buyerId=" + buyerId + ", buyerUsername=" + buyerUsername + ", buyerPassword=" + buyerPassword
				+ ", buyerEmail=" + buyerEmail + ", buyerMobile=" + buyerMobile + ", buyerDate=" + buyerDate
				+ ", allBills=" + allBills + "]";
	}
}
