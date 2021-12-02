package com.organissembly.bean;

import java.io.InputStream;

public class Organization {
private int id;
private String orgId,orgName,orgAbout,orgVision,orgMission,orgAdviserId,orgPresidentId,orgSecretaryId,orgProId,isEnabled,base64Image,orgAdviserName,orgPresidentName,orgSecretaryName,orgProName;
private InputStream orgImage;


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
public String getIsEnabled() {
	return isEnabled;
}
public void setIsEnabled(String isEnabled) {
	this.isEnabled = isEnabled;
}
public String getOrgId() {
	return orgId;
}
public void setOrgId(String orgId) {
	this.orgId = orgId;
}
public String getOrgName() {
	return orgName;
}
public void setOrgName(String orgName) {
	this.orgName = orgName;
}
public String getOrgAbout() {
	return orgAbout;
}
public void setOrgAbout(String orgAbout) {
	this.orgAbout = orgAbout;
}
public String getOrgVision() {
	return orgVision;
}
public void setOrgVision(String orgVision) {
	this.orgVision = orgVision;
}
public String getOrgMission() {
	return orgMission;
}
public void setOrgMission(String orgMission) {
	this.orgMission = orgMission;
}
public String getOrgAdviserId() {
	return orgAdviserId;
}
public void setOrgAdviserId(String orgAdviserId) {
	this.orgAdviserId = orgAdviserId;
}
public String getOrgPresidentId() {
	return orgPresidentId;
}
public void setOrgPresidentId(String orgPresidentId) {
	this.orgPresidentId = orgPresidentId;
}
public String getOrgSecretaryId() {
	return orgSecretaryId;
}
public void setOrgSecretaryId(String orgSecretaryId) {
	this.orgSecretaryId = orgSecretaryId;
}
public String getOrgProId() {
	return orgProId;
}
public void setOrgProId(String orgProId) {
	this.orgProId = orgProId;
}
public InputStream getOrgImage() {
	return orgImage;
}
public void setOrgImage(InputStream blob) {
	this.orgImage = blob;
}

public String getOrgAdviserName() {
	return orgAdviserName;
}
public void setOrgAdviserName(String orgAdviserName) {
	this.orgAdviserName = orgAdviserName;
}
public String getOrgPresidentName() {
	return orgPresidentName;
}
public void setOrgPresidentName(String orgPresidentName) {
	this.orgPresidentName = orgPresidentName;
}
public String getOrgSecretaryName() {
	return orgSecretaryName;
}
public void setOrgSecretaryName(String orgSecretaryName) {
	this.orgSecretaryName = orgSecretaryName;
}
public String getOrgProName() {
	return orgProName;
}
public void setOrgProName(String orgProName) {
	this.orgProName = orgProName;
}

}
