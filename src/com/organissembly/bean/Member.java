package com.organissembly.bean;

public class Member {
private int id;
private String userId,orgId,isActive,memberRole,dateJoined;
private String firstName, middleName, lastName, number, year, section, userLevel;

public String getUserLevel() {
	return userLevel;
}
public void setUserLevel(String userLevel) {
	this.userLevel = userLevel;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getOrgId() {
	return orgId;
}
public void setOrgId(String orgId) {
	this.orgId = orgId;
}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
public String getMemberRole() {
	return memberRole;
}
public void setMemberRole(String memberRole) {
	this.memberRole = memberRole;
}
public String getDateJoined() {
	return dateJoined;
}
public void setDateJoined(String dateJoined) {
	this.dateJoined = dateJoined;
}


public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}

}
