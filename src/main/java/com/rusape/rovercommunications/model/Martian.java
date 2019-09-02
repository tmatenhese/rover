package com.rusape.rovercommunications.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="martian")
public class Martian extends BaseEntity{
	private float xCoordinate;
	private float yCoordinate;
	private float direction;
	private float speed;
	private TelemetryMessage telemetryMessage;
	public float getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(float xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public float getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(float yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "telemetry_message_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore	
	public TelemetryMessage getTelemetryMessage() {
		return telemetryMessage;
	}
	public void setTelemetryMessage(TelemetryMessage telemetryMessage) {
		this.telemetryMessage = telemetryMessage;
	}	
	@Override
	public String toString() {
		return "Martian [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", direction=" + direction
				+ ", speed=" + speed + "]";
	}
}
