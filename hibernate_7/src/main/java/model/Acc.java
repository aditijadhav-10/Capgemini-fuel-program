package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Acc {
	@Id
	private int aid;
	private String location;
	private String type;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
