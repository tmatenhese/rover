package com.rusape.rovercommunications.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="events_messages")
public class EventsMessages extends BaseEntity {
	
	private char messageTag;
	private float timestamp;
	public char getMessageTag() {
		return messageTag;
	}
	public void setMessageTag(char messageTag) {
		this.messageTag = messageTag;
	}
	public float getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "EventsMessages [messageTag=" + messageTag + ", timestamp=" + timestamp + "]";
	}
	
}
