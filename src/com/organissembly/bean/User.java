package com.organissembly.bean;

public class User {
private int id,points;
private String userId,email,password,firstName,middleName,lastName,dateCreated,dateUpdated,userLevel,fullName;
private String number, year, section;

/* Unique auto increment ID */
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

/* userId derived from unique id */
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

/* unique email for each student/User */
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

/* password for each student/User */
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

/* user first Name*/
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/* user middle Name*/
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

/* user last Name*/
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/* user points */
public int getUserPoints() {
	return points;
}
public void setUserPoints(int points) {
	this.points = points;
}

/* user date creation */
public String getDateCreated() {
	return dateCreated;
}
public void setDateCreated(String dateC) {
	this.dateCreated = dateC;
}

/* user date updated */
public String getDateUpdated() {
	return dateUpdated;
}
public void setDateUpdated(String dateU) {
	this.dateUpdated = dateU;
}

/* user level */
public String getUserLevel() {
	//if (level == null) {
	//	level = "Student";
	//}
	return userLevel;
}
public void setUserLevel(String level) {
	this.userLevel = level;
}

/* user full Name*/
public String getFullName() {
	return fullName;
}
public void setFullName(String first, String middle, String last) {
	this.fullName = first+" "+middle+" "+last;
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
