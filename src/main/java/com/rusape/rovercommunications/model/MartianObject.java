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
@Table(name="martian_object")
public class MartianObject extends BaseEntity{
	private float xCoordinate;
	private float yCoordinate;
	private float radius;
	private String objectKind;
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
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}

	public String getObjectKind() {
		return objectKind;
	}
	public void setObjectKind(String objectKind) {
		this.objectKind = objectKind;
	}
	@Override
	public String toString() {
		return "MartianObject [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", radius=" + radius
				+ ", objectKind=" + objectKind + "]";
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

}
