package com.rusape.rovercommunications.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="initialization_message")
public class InitializationMessage extends BaseEntity{
    private float xCoordinate;
    private float yCoordinate;
    private long timeLimit;
    private float minimumSensorRange;
    private float maximumSensorRange;
    private float maximumSpeed;
    private float maximumTurn;
    private float maximumHardTurn;

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
	public long getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(long timeLimit) {
		this.timeLimit = timeLimit;
	}
	public float getMinimumSensorRange() {
		return minimumSensorRange;
	}
	public void setMinimumSensorRange(float minimumSensorRange) {
		this.minimumSensorRange = minimumSensorRange;
	}
	public float getMaximumSensorRange() {
		return maximumSensorRange;
	}
	public void setMaximumSensorRange(float maximumSensorRange) {
		this.maximumSensorRange = maximumSensorRange;
	}
	public float getMaximumSpeed() {
		return maximumSpeed;
	}
	public void setMaximumSpeed(float maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	public float getMaximumTurn() {
		return maximumTurn;
	}
	public void setMaximumTurn(float maximumTurn) {
		this.maximumTurn = maximumTurn;
	}
	public float getMaximumHardTurn() {
		return maximumHardTurn;
	}
	public void setMaximumHardTurn(float maximumHardTurn) {
		this.maximumHardTurn = maximumHardTurn;
	}

	@Override
	public String toString() {
		return "InitializationMessage [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", timeLimit="
				+ timeLimit + ", minimumSensorRange=" + minimumSensorRange + ", maximumSensorRange="
				+ maximumSensorRange + ", maximumSpeed=" + maximumSpeed + ", maximumTurn=" + maximumTurn
				+ ", maximumHardTurn=" + maximumHardTurn + "]";
	}  
}
