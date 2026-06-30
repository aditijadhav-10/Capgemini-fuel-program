package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int sid;
	private String name;
	@ManyToMany
	private List<Course> c = new ArrayList<Course>();

	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getC() {
		return c;
	}

	public void setC(List<Course> c) {
		this.c = c;
	}

	
	
}
