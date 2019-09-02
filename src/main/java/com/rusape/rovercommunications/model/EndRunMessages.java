package com.rusape.rovercommunications.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="end_run_messages")
public class EndRunMessages extends BaseEntity{
	
	private Character endRun;
	private float timeStamp;
	private int score;
	public Character getEndRun() {
		return endRun;
	}
	public void setEndRun(Character endRun) {
		this.endRun = endRun;
	}
	public float getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(float timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "EndRunMessages [endRun=" + endRun + ", timeStamp=" + timeStamp + ", score=" + score + "]";
	}	
}
