package com.organissembly.bean;

public class Event {
	private int id;
	private String eventId,eventOrgId,eventPostedById,eventTitle,eventDescription,eventStatus,eventIsApproved,eventIsEnabled,eventDateCreated,eventOrgName;
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
}
