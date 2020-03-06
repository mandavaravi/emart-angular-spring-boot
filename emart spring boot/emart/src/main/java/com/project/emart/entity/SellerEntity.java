package com.project.emart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller_signup_table")
public class SellerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_id")
	int sellerId;
	
	@Column(name = "seller_username")
	String sellerUsername;
	
	@Column(name = "seller_password")
	String sellerPassword;
	
	@Column(name = "seller_company")
	String sellerCompany;
	
	@Column(name = "seller_brief")
	String sellerBrief;
	
	@Column(name = "seller_gst")
	int sellerGst;
	
	@Column(name = "seller_address")
	String sellerAddress;
	
	@Column(name = "seller_email")
	String sellerEmail;
	
	@Column(name = "seller_website")
	String sellerWebsite;
	
	@Column(name = "seller_contact")
	int sellerContact;

	public SellerEntity() {
		super();
	}

	public SellerEntity(int sellerId, String sellerUsername, String sellerPassword, String sellerCompany,
			String sellerBrief, int sellerGst, String sellerAddress, String sellerEmail, String sellerWebsite,
			int sellerContact) {
		super();
		this.sellerId = sellerId;
		this.sellerUsername = sellerUsername;
		this.sellerPassword = sellerPassword;
		this.sellerCompany = sellerCompany;
		this.sellerBrief = sellerBrief;
		this.sellerGst = sellerGst;
		this.sellerAddress = sellerAddress;
		this.sellerEmail = sellerEmail;
		this.sellerWebsite = sellerWebsite;
		this.sellerContact = sellerContact;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerCompany() {
		return sellerCompany;
	}

	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}

	public String getSellerBrief() {
		return sellerBrief;
	}

	public void setSellerBrief(String sellerBrief) {
		this.sellerBrief = sellerBrief;
	}

	public int getSellerGst() {
		return sellerGst;
	}

	public void setSellerGst(int sellerGst) {
		this.sellerGst = sellerGst;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerWebsite() {
		return sellerWebsite;
	}

	public void setSellerWebsite(String sellerWebsite) {
		this.sellerWebsite = sellerWebsite;
	}

	public int getSellerContact() {
		return sellerContact;
	}

	public void setSellerContact(int sellerContact) {
		this.sellerContact = sellerContact;
	}

	@Override
	public String toString() {
		return "SellerEntity [sellerId=" + sellerId + ", sellerUsername=" + sellerUsername + ", sellerPassword="
				+ sellerPassword + ", sellerCompany=" + sellerCompany + ", sellerBrief=" + sellerBrief + ", sellerGst="
				+ sellerGst + ", sellerAddress=" + sellerAddress + ", sellerEmail=" + sellerEmail + ", sellerWebsite="
				+ sellerWebsite + ", sellerContact=" + sellerContact + "]";
	}
	
	
}
