package com.organissembly.bean;

import java.io.InputStream;

public class Event {
	private int id;
	private String eventId,eventOrgId,eventPostedById,eventTitle,eventDescription,eventStatus,eventIsApproved,eventIsEnabled,eventDateCreated,eventOrgName,eventActualDate,eventActualTime,base64Image;
	private InputStream eventImage;
	
	 public String getBase64Image() {
	        return base64Image;
	    }
	    public void setBase64Image(String base64Image) {
	        this.base64Image = base64Image;
	    }
	
	public String getEventActualDate() {
		return eventActualDate;
	}
	public void setEventActualDate(String eventActualDate) {
		this.eventActualDate = eventActualDate;
	}
	public String getEventActualTime() {
		return eventActualTime;
	}
	public void setEventActualTime(String eventActualTime) {
		this.eventActualTime = eventActualTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventOrgId() {
		return eventOrgId;
	}
	public void setEventOrgId(String eventOrgId) {
		this.eventOrgId = eventOrgId;
	}
	public String getEventPostedById() {
		return eventPostedById;
	}
	public void setEventPostedById(String eventPostedById) {
		this.eventPostedById = eventPostedById;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getEventIsApproved() {
		return eventIsApproved;
	}
	public void setEventIsApproved(String eventIsApproved) {
		this.eventIsApproved = eventIsApproved;
	}
	public String getEventIsEnabled() {
		return eventIsEnabled;
	}
	public void setEventIsEnabled(String eventIsEnabled) {
		this.eventIsEnabled = eventIsEnabled;
	}
	public String getEventDateCreated() {
		return eventDateCreated;
	}
	public void setEventDateCreated(String eventDateCreated) {
		this.eventDateCreated = eventDateCreated;
	}
	public void setEventOrgName (String eventOrgName) {
		this.eventOrgName = eventOrgName;
	}
	public String getEventOrgName() {
		return eventOrgName;
	}
	
	public InputStream getEventImage() {
		return eventImage;
	}
	public void setEventImage(InputStream blob) {
		this.eventImage = blob;
	}
}
