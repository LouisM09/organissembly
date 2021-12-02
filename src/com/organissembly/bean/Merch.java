package com.organissembly.bean;

import java.io.InputStream;

public class Merch {
	private int id;
	private String merchId,merchOrgId,merchPostedById,merchName,merchDescription,merchPrice,merchIsApproved,merchIsEnabled,merchDateCreated,base64Image;
	private InputStream merchImage;
	
    public String getBase64Image() {
        return base64Image;
    }
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getMerchOrgId() {
		return merchOrgId;
	}
	public void setMerchOrgId(String merchOrgId) {
		this.merchOrgId = merchOrgId;
	}
	public String getMerchPostedById() {
		return merchPostedById;
	}
	public void setMerchPostedById(String merchPostedById) {
		this.merchPostedById = merchPostedById;
	}
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public String getMerchDescription() {
		return merchDescription;
	}
	public void setMerchDescription(String merchDescription) {
		this.merchDescription = merchDescription;
	}
	public String getMerchPrice() {
		return merchPrice;
	}
	public void setMerchPrice(String merchPrice) {
		this.merchPrice = merchPrice;
	}
	public String getMerchIsApproved() {
		return merchIsApproved;
	}
	public void setMerchIsApproved(String merchIsApproved) {
		this.merchIsApproved = merchIsApproved;
	}
	public String getMerchIsEnabled() {
		return merchIsEnabled;
	}
	public void setMerchIsEnabled(String merchIsEnabled) {
		this.merchIsEnabled = merchIsEnabled;
	}
	public String getMerchDateCreated() {
		return merchDateCreated;
	}
	public void setMerchDateCreated(String merchDateCreated) {
		this.merchDateCreated = merchDateCreated;
	}
	public InputStream getMerchImage() {
		return merchImage;
	}
	public void setMerchImage(InputStream blob) {
		this.merchImage = blob;
	}
}
