package com.rusape.rovercommunications.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="telemetry_message")
public class TelemetryMessage extends BaseEntity{	
	private int timeStamp;
	private String vehicleControl;
	private float vehicleXCoordinate;
	private float vehicleYCoordinate;
	private float vehicleDirection;
	private float vehicleSpeed;
	private List<MartianObject> martianObject;
	private List<Martian> martians;
	private String controlMessage;
	public String getVehicleControl() {
		return vehicleControl;
	}
	public void setVehicleControl(String vehicleControl) {
		this.vehicleControl = vehicleControl;
	}
	public float getVehicleXCoordinate() {
		return vehicleXCoordinate;
	}
	public void setVehicleXCoordinate(float vehicleXCoordinate) {
		this.vehicleXCoordinate = vehicleXCoordinate;
	}
	public float getVehicleYCoordinate() {
		return vehicleYCoordinate;
	}
	public void setVehicleYCoordinate(float vehicleYCoordinate) {
		this.vehicleYCoordinate = vehicleYCoordinate;
	}
	public float getVehicleDirection() {
		return vehicleDirection;
	}
	public void setVehicleDirection(float vehicleDirection) {
		this.vehicleDirection = vehicleDirection;
	}
	public float getVehicleSpeed() {
		return vehicleSpeed;
	}
	public void setVehicleSpeed(float vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}
	@Transient
	@OneToMany(mappedBy = "telemetryMessage")
	public List<MartianObject> getMartianObject() {
		return martianObject;
	}
	public void setMartianObject(List<MartianObject> martianObject) {
		this.martianObject = martianObject;
	}
	@Transient
	@OneToMany(mappedBy = "telemetryMessage")
	public List<Martian> getMartians() {
		return martians;
	}
	public void setMartians(List<Martian> martians) {
		this.martians = martians;
	}
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getControlMessage() {
		return controlMessage;
	}
	public void setControlMessage(String controlMessage) {
		this.controlMessage = controlMessage;
	}
	@Override
	public String toString() {
		return "TelemetryMessage [timeStamp=" + timeStamp + ", vehicleControl=" + vehicleControl
				+ ", vehicleXCoordinate=" + vehicleXCoordinate + ", vehicleYCoordinate=" + vehicleYCoordinate
				+ ", vehicleDirection=" + vehicleDirection + ", vehicleSpeed=" + vehicleSpeed + ", martianObject="
				+ martianObject + ", martians=" + martians + ", controlMessage=" + controlMessage + "]";
	}
}
