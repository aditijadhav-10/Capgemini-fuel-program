package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	private int cid;
	private String cname;
	@ManyToMany
	private List<Student> s = new ArrayList<Student>();

	public List<Student> getS() {
		return s;
	}

	public void setS(List<Student> s) {
		this.s = s;
	}

	public Course(int cid, String cname) {

		this.cid = cid;
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
